package com.tim23.fishnchill.general.model;

import com.tim23.fishnchill.user.model.User;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    private Long id;

    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BaseEntity entity;
}
