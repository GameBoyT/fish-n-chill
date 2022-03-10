package com.tim23.fishnchill.user.service;

import com.tim23.fishnchill.general.exception.ResourceNotFoundException;
import com.tim23.fishnchill.user.dto.ClientDto;
import com.tim23.fishnchill.user.dto.ClientProfileDto;
import com.tim23.fishnchill.user.model.Client;
import com.tim23.fishnchill.user.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    private ModelMapper modelMapper;
    private ClientRepository clientRepository;


    public List<ClientDto> findAll() {
        TypeToken<List<ClientDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(clientRepository.findAll(), typeToken.getType());
    }

    public ClientProfileDto findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
        return modelMapper.map(client, ClientProfileDto.class);
    }

}
