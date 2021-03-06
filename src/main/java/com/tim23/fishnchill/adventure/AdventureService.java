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
        Adventure adventure = adventureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adventure", id));
        return modelMapper.map(adventure, AdventureDto.class);
    }

    public List<AdventureDto> findByNameContaining(String name) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByNameContainingIgnoreCase(name), typeToken.getType());
    }

    public List<AdventureDto> findByAddressContaining(String address) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByAddressContainingIgnoreCase(address), typeToken.getType());
    }

    public List<AdventureDto> findByDescriptionContaining(String description) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByDescriptionContainingIgnoreCase(description), typeToken.getType());
    }

    public List<AdventureDto> findByAnything(String name, String address, String description) {
        TypeToken<List<AdventureDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(adventureRepository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrDescriptionContainingIgnoreCase(name, address, description), typeToken.getType());
    }
}
