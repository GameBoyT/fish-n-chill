package com.tim23.fishnchill.user.dto;

import com.tim23.fishnchill.reservation.dto.CottageReservationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientProfileDto {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private CottageReservationDto cottageReservation;
}

