package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.general.dto.EntityDto;
import com.tim23.fishnchill.general.model.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientReservationDto {
    private Long Id;

    private Integer duration;

    private Integer maximalGuests;

    private BigDecimal price;

    private EntityDto entity;

    //Ovo mozda ne treba ali mozda ce trebati
    private EntityType entityType;
}
