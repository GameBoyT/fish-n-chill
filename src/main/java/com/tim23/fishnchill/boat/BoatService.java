package com.tim23.fishnchill.boat;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoatService {

    private BoatRepository boatRepository;
    private ModelMapper modelMapper;

    public List<BoatDto> findAll() {
        TypeToken<List<BoatDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(boatRepository.findAll(), typeToken.getType());
    }
}
