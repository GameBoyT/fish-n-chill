package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.general.dto.EntityDto;
import com.tim23.fishnchill.general.model.enums.EntityType;
import com.tim23.fishnchill.user.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long Id;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    private ClientDto client;

    private EntityDto entity;

    //Ovo mozda ne treba ali mozda ce trebati
    private EntityType entityType;
}
