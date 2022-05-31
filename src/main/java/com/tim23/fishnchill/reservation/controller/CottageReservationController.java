package com.tim23.fishnchill.reservation.controller;

import com.tim23.fishnchill.reservation.dto.CottageReservationDto;
import com.tim23.fishnchill.reservation.dto.NewReservationDto;
import com.tim23.fishnchill.reservation.service.CottageReservationService;
import com.tim23.fishnchill.security.TokenUtils;
import com.tim23.fishnchill.user.controller.UserController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CottageReservationController {
    private TokenUtils tokenUtils;
    private CottageReservationService cottageReservationService;

    @GetMapping("/cottages/reservations")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageReservationDto> findAll() {
        return cottageReservationService.findAll();
    }

    @GetMapping("/cottages/reservations/{reservationId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CottageReservationDto findById(@PathVariable("reservationId") Long reservationId) {
        return cottageReservationService.findById(reservationId);
    }

    @GetMapping("/cottages/{cottageId}/reservations")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageReservationDto> findAllCottageReservation(@PathVariable("cottageId") Long cottageId) {
        return cottageReservationService.findAllReservationsForCottage(cottageId);
    }

    @PostMapping("/cottages/reservations")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CottageReservationDto save(@RequestBody NewReservationDto newReservationDto, @RequestHeader ("Authorization") String authToken) {
        authToken = authToken.replace("Bearer","");
        //System.out.println(this.tokenUtils.getIdFromToken(authToken));
        newReservationDto.setClientId(Long.parseLong(this.tokenUtils.getIdFromToken(authToken)));

        return cottageReservationService.save(newReservationDto);

    }

}
