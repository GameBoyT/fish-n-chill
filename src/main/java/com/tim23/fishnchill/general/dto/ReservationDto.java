package com.tim23.fishnchill.general.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    private Long userId;

    private Long entityId;
}
