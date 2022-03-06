package com.tim23.fishnchill.adventure;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdventureService {

    private AdventureRepository adventureRepository;
    private ModelMapper modelMapper;

    
    public List<AdventureDto> findAll() {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findAll(), typeToken.getType());
    }
}
