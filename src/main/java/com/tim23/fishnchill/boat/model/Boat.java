package com.tim23.fishnchill.boat.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Boat {
    @Id
    private Long id;

    private String name;

    private String type;

    private String length;

    private String engineId;

    private String enginePower;

    private String maxSpeed;

    private String gps;

    private String radar;

    private String vhf;

    private String fishFinder;

}
