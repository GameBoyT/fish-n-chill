package com.tim23.fishnchill.user.service;

import com.tim23.fishnchill.general.exception.ResourceNotFoundException;
import com.tim23.fishnchill.user.dto.ClientDto;
import com.tim23.fishnchill.user.dto.ClientProfileDto;
import com.tim23.fishnchill.user.dto.RegistrationDto;
import com.tim23.fishnchill.user.model.Authority;
import com.tim23.fishnchill.user.model.Client;
import com.tim23.fishnchill.user.model.User;
import com.tim23.fishnchill.user.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    private ModelMapper modelMapper;
    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;
    private AuthorityService authService;


    public List<ClientDto> findAll() {
        TypeToken<List<ClientDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(clientRepository.findAll(), typeToken.getType());
    }

    public ClientProfileDto findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
        return modelMapper.map(client, ClientProfileDto.class);
    }

    public Client saveClient(Client c) {
       return this.clientRepository.save(c);
    }

    public Client save(RegistrationDto registrationDTO) {
        Client c = new Client();
        c.setUsername(registrationDTO.getUsername());
        // pre nego sto postavimo lozinku u atribut hesiramo je
        c.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        c.setFirstName(registrationDTO.getFirstName());
        c.setLastName(registrationDTO.getLastName());
        c.setEmail(registrationDTO.getEmail());
        c.setCountry(registrationDTO.getCountry());
        c.setCity(registrationDTO.getCity());
        c.setAddress(registrationDTO.getAddress());
        c.setPhoneNumber(registrationDTO.getPhoneNumber());
        c.setPenaltyCount(0);
        c.setEnabled(false);

        List<Authority> auth = authService.findByName("ROLE_CLIENT");
        c.setAuthorities(auth);

        return this.clientRepository.save(c);
    }

    public void deleteClient(Client client) {
        this.clientRepository.delete(client);
    }
}
