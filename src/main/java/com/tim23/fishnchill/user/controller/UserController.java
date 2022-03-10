package com.tim23.fishnchill.user.controller;

import com.tim23.fishnchill.user.dto.UserDto;
import com.tim23.fishnchill.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;


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

    @GetMapping("/whoami")
    @PreAuthorize("hasRole('CLIENT')")
    public UserDto user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }

}
