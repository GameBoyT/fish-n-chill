package com.tim23.fishnchill.adventure;

import com.tim23.fishnchill.general.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

    public AdventureDto findById(Long id) {
        Adventure boat = adventureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Boat", id));
        return modelMapper.map(boat, AdventureDto.class);
    }

    public List<AdventureDto> findByNameContaining(String name) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByNameContainingIgnoreCase(name), typeToken.getType());
    }

    public List<AdventureDto> findByDescriptionContaining(String description) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByDescriptionContainingIgnoreCase(description), typeToken.getType());
    }

    public List<AdventureDto> findByAnything(String name, String description) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(name, description), typeToken.getType());
    }
}
