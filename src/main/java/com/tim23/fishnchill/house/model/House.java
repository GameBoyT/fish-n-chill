package com.tim23.fishnchill.house.model;

import com.tim23.fishnchill.user.model.HouseOwner;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class House {
    @Id
    private Long id;

    private String name;

    private String adress;

    private String description;

    //TODO image storage, probably a list of strings (urls)
//    public Images;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<Room>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private HouseOwner owner;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<Rating>();

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<HouseReservation> houseReservations = new HashSet<HouseReservation>();

}
