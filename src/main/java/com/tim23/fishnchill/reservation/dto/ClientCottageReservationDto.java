package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.cottage.CottageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCottageReservationDto {
    private Long id;

    private Integer duration;

    private Integer maximalGuests;

    private BigDecimal price;

    private CottageDto cottage;
}

