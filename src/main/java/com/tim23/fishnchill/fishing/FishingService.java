package com.tim23.fishnchill.fishing;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingService {
    @Autowired
    private FishingRepository fishingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<FishingDTO> findAll() {
        TypeToken<List<FishingDTO>> typeToken = new TypeToken<>() {};
        return modelMapper.map(fishingRepository.findAll(), typeToken.getType());
    }
}
