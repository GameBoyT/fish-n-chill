package com.tim23.fishnchill.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewReservationDto {
    private Integer duration;

    private Integer maximalGuests;

    private BigDecimal price;

    private Long clientId;

    private Long entityId;
}
