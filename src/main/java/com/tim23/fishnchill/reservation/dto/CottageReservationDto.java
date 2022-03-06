package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.cottage.CottageDto;
import com.tim23.fishnchill.user.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageReservationDto {
    private Long id;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    private ClientDto client;

    private CottageDto cottage;
}

