package com.tim23.fishnchill.user.service;

import com.tim23.fishnchill.user.dto.ClientDto;
import com.tim23.fishnchill.user.dto.ClientProfileDto;
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

    public ClientProfileDto findOne(Long id) {
        ClientProfileDto client = modelMapper.map(clientRepository.getById(id), ClientProfileDto.class);
        return client;
    }

}
