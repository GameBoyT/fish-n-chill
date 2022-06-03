package com.tim23.fishnchill.user.controller;

import antlr.BaseAST;
import com.tim23.fishnchill.general.exception.ResourceConflictException;
import com.tim23.fishnchill.security.TokenUtils;
import com.tim23.fishnchill.user.dto.PasswordChangeDto;
import com.tim23.fishnchill.user.dto.RegistrationDto;
import com.tim23.fishnchill.user.dto.UpdateDto;
import com.tim23.fishnchill.user.dto.UserDto;
import com.tim23.fishnchill.user.model.Authority;
import com.tim23.fishnchill.user.model.Client;
import com.tim23.fishnchill.user.model.User;
import com.tim23.fishnchill.user.service.AuthorityService;
import com.tim23.fishnchill.user.service.ClientService;
import com.tim23.fishnchill.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;
    private ClientService clientService;
    private TokenUtils tokenUtils;
    private AuthorityService authorityService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> loadAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public UserDto loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @GetMapping("/whoami")
    @PreAuthorize("hasRole('CLIENT')")
    public UserDto user(HttpServletRequest request){

        String token = tokenUtils.getToken(request);
        Long id = Long.parseLong(this.tokenUtils.getIdFromToken(token));
        return this.userService.findById(id);
    }

    @GetMapping("/rolerequests")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> findOwnerRequests(){
        List<UserDto> userDtos = new ArrayList<UserDto>();
        List<Authority> authorities = authorityService.findAllContainingRequest();
        for(Authority auth : authorities){
            userDtos.add(userService.findById(auth.getId()));
        }
        return userDtos;
    }

    @PostMapping("/accept-request/{id}")
    public ResponseEntity<?>acceptOwnerRequest(@PathVariable Long id) throws Exception{
        authorityService.confirmRequest(id);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }


    @PostMapping("/update")
    public ResponseEntity<User> addUser(@Valid @RequestBody UpdateDto updateDto, HttpServletRequest request) {
        if(updateDto.getRole().equalsIgnoreCase("client")) {
            String token = tokenUtils.getToken(request);
            Long id = Long.parseLong(this.tokenUtils.getIdFromToken(token));
            Client client = this.clientService.findByIdPure(id);
            client = this.clientService.update(updateDto, client);

            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }
        else{
            //TODO dio za ownere
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }


    @PostMapping(value = "/change-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeDto passwordChangeDTO, HttpServletRequest request) {
        if(passwordChangeDTO.getRole().equalsIgnoreCase("client")){
            String token = tokenUtils.getToken(request);
            Long id = Long.parseLong(this.tokenUtils.getIdFromToken(token));
            Client client = this.clientService.findByIdPure(id);
            if(passwordEncoder.matches(passwordChangeDTO.getOldPassword(), client.getPassword())){
                clientService.changePassword(passwordChangeDTO.getNewPassword(), client);
                return new ResponseEntity<>(client, HttpStatus.CREATED);
            }
            else
                throw new ResourceConflictException("Old pw incorrect");
        }
        else{
            //TODO dio za ownere
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }

    }



}
