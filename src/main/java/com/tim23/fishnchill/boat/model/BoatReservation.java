package com.tim23.fishnchill.boat.model;

import com.tim23.fishnchill.user.model.User;

import javax.persistence.*;

@Entity
public class BoatReservation {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
}
