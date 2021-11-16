package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.boat.BoatDTO;
import com.tim23.fishnchill.cottage.model.Cottage;
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

    public List<CottageDTO> findAll()
    {
        TypeToken<List<CottageDTO>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findAll(), typeToken.getType());
    }
}
