package com.tim23.fishnchill.reservation.dto;

import com.tim23.fishnchill.general.dto.EntityDto;
import com.tim23.fishnchill.general.model.enums.EntityType;
import com.tim23.fishnchill.user.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FastReservationDto {
    private Long id;

    private Integer duration;

    private Integer maximalGuests;

    private BigDecimal price;

    private ClientDto client;

    private EntityDto entity;

    //Ovo mozda ne treba ali mozda ce trebati
    private EntityType entityType;

    private Boolean isReserved;

    private LocalDateTime actionEnd;
}
