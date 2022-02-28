package com.tim23.fishnchill.cottage;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService {
    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CottageDto> findAll() {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findAll(), typeToken.getType());
    }

    public CottageDto findOne(Long id) {
        return modelMapper.map(cottageRepository.getById(id), CottageDto.class);
    }

    public List<CottageDto> findByNameContaining(String name) {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findByNameContainingIgnoreCase(name), typeToken.getType());
    }
}
