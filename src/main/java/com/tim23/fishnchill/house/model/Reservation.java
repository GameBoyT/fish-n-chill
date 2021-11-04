package com.tim23.fishnchill.house.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {
    @Id
    private Long id;

    private LocalDateTime start;

    private LocalDateTime end;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;
}
