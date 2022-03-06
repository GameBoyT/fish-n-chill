package com.tim23.fishnchill.cottage.service;

import com.tim23.fishnchill.cottage.CottageDto;
import com.tim23.fishnchill.cottage.repository.CottageRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CottageService {
    private CottageRepository cottageRepository;
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
