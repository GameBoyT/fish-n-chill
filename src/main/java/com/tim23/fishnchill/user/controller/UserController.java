package com.tim23.fishnchill.user.controller;

import com.tim23.fishnchill.security.TokenUtils;
import com.tim23.fishnchill.user.dto.UserDto;
import com.tim23.fishnchill.user.model.Authority;
import com.tim23.fishnchill.user.service.AuthorityService;
import com.tim23.fishnchill.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;
    private TokenUtils tokenUtils;
    private AuthorityService authorityService;

    @GetMapping("/users")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> loadAll() {
        return this.userService.findAll();
    }

    @GetMapping("/users/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public UserDto loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @GetMapping("/users/whoami")
    @PreAuthorize("hasRole('CLIENT')")
    public UserDto user(HttpServletRequest request){

        String token = tokenUtils.getToken(request);
        Long id = Long.parseLong(this.tokenUtils.getIdFromToken(token));
        return this.userService.findById(id);
    }

    @GetMapping("/users/rolerequests")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> findOwnerRequests(){
        List<UserDto> userDtos = new ArrayList<UserDto>();
        List<Authority> authorities = authorityService.findAllContainingRequest();
        for(Authority auth : authorities){
            userDtos.add(userService.findById(auth.getId()));
        }
        return userDtos;
    }

    @PostMapping("/users/accept-request/{id}")
    public ResponseEntity<?>acceptOwnerRequest(@PathVariable Long id) throws Exception{
        authorityService.confirmRequest(id);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }





}
