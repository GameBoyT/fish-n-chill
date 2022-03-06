package com.tim23.fishnchill.user.service;

import com.tim23.fishnchill.user.dto.RegistrationDto;
import com.tim23.fishnchill.user.model.Authority;
import com.tim23.fishnchill.user.model.User;
import com.tim23.fishnchill.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthorityService authService;


    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findById(id).orElseGet(null);
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }

    public User save(RegistrationDto registrationDTO) {
        User u = new User();
        u.setUsername(registrationDTO.getUsername());
        // pre nego sto postavimo lozinku u atribut hesiramo je
        u.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        u.setFirstName(registrationDTO.getFirstName());
        u.setLastName(registrationDTO.getLastName());
        u.setEmail(registrationDTO.getEmail());
        // Djole - Ovo je bilo disable-ovano
        u.setEnabled(true);

        List<Authority> auth = authService.findByName("ROLE_USER");
        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        u.setAuthorities(auth);

        return this.userRepository.save(u);
    }

}
