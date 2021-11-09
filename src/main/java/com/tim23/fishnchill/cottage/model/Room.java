package com.tim23.fishnchill.cottage.model;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    private Long id;
    private Integer numberOfBeds;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cottage cottage;
}
