package com.tim23.fishnchill.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewReservationDto {
    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    private Long clientId;

    private Long entityId;
}
