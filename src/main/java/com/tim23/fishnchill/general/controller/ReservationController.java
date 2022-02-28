package com.tim23.fishnchill.general.controller;

import com.tim23.fishnchill.general.DTO.ReservationDto;
import com.tim23.fishnchill.general.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ReservationDto> findAll() {
        return reservationService.findAll();
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ReservationDto findOne(@PathVariable("id") Long id) {
        return reservationService.findOne(id);
    }

}
