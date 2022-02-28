package com.tim23.fishnchill.general.service;

import com.tim23.fishnchill.general.DTO.ReservationDTO;
import com.tim23.fishnchill.general.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReservationDTO> findAll() {
        TypeToken<List<ReservationDTO>> typeToken = new TypeToken<>() {};
        return modelMapper.map(reservationRepository.findAll(), typeToken.getType());
    }

    public ReservationDTO findOne(Long id) {
        return modelMapper.map(reservationRepository.getById(id), ReservationDTO.class);
    }
}
