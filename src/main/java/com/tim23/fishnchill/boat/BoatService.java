package com.tim23.fishnchill.boat;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BoatDTO> findAll() {
        TypeToken<List<BoatDTO>> typeToken = new TypeToken<>() {
        };
        return modelMapper.map(boatRepository.findAll(), typeToken.getType());
    }
}
