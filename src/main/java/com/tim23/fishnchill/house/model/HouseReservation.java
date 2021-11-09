package com.tim23.fishnchill.house.model;

import com.tim23.fishnchill.user.model.User;

import javax.persistence.*;

@Entity
public class HouseReservation {
    @Id
    private Long id;

//    private LocalDateTime start;
//
//    private LocalDateTime end;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private House house;
}
