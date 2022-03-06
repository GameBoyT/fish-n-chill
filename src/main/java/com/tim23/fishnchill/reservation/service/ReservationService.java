package com.tim23.fishnchill.reservation.service;

import com.tim23.fishnchill.reservation.dto.NewReservationDto;
import com.tim23.fishnchill.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservationService {

    private ModelMapper modelMapper;
    private ReservationRepository reservationRepository;
    private CottageReservationService cottageReservationService;


    public List<NewReservationDto> findAll() {
        TypeToken<List<NewReservationDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(reservationRepository.findAll(), typeToken.getType());
    }

    public NewReservationDto findOne(Long id) {
        return modelMapper.map(reservationRepository.getById(id), NewReservationDto.class);
    }

}
