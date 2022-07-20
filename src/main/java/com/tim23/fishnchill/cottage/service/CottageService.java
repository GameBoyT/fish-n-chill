package com.tim23.fishnchill.cottage.service;

import com.tim23.fishnchill.cottage.CottageDto;
import com.tim23.fishnchill.cottage.model.Cottage;
import com.tim23.fishnchill.cottage.repository.CottageRepository;
import com.tim23.fishnchill.general.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CottageService {

    private CottageRepository cottageRepository;
    private ModelMapper modelMapper;

    public Cottage add(CottageDto newCottage){
        Cottage cottage = new Cottage();
        modelMapper.map(newCottage, cottage);
        return cottageRepository.save(cottage);
    }
    public Cottage update(CottageDto newCottage){
        Cottage cottage = cottageRepository.getById(newCottage.getId());
        modelMapper.map(newCottage, cottage);
        return cottageRepository.save(cottage);
    }

    public List<CottageDto> findAll() {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findAll(), typeToken.getType());
    }

    public CottageDto findById(Long id) {
        Cottage cottage = cottageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cottage", id));
        return modelMapper.map(cottage, CottageDto.class);
    }

    public List<CottageDto> findByNameContaining(String name) {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findByNameContainingIgnoreCase(name), typeToken.getType());
    }

    public List<CottageDto> findByDescriptionContaining(String description) {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findByDescriptionContainingIgnoreCase(description), typeToken.getType());
    }

    public List<CottageDto> findByAddressContaining(String address) {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findByAddressContainingIgnoreCase(address), typeToken.getType());
    }

    public List<CottageDto> findByAnything(String name, String address, String description) {
        TypeToken<List<CottageDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(cottageRepository.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrDescriptionContainingIgnoreCase(name, address, description), typeToken.getType());
    }
    public List<CottageDto> getAllForOwner(Long id){
        List<Cottage>cottages = cottageRepository.findByOwner_Id(id);
        List<CottageDto>cottageDtos = new ArrayList<CottageDto>();
        modelMapper.map(cottages,cottageDtos);
        return cottageDtos;
    }
}
