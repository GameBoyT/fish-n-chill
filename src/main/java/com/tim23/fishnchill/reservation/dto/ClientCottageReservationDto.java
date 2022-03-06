package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.cottage.CottageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCottageReservationDto {
    private Long id;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    private CottageDto cottage;
}

