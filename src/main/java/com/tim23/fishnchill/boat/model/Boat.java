package com.tim23.fishnchill.boat.model;

import com.tim23.fishnchill.general.model.BaseEntity;

import javax.persistence.*;


@Entity
public class Boat extends BaseEntity {
//    @Id
//    private Long id;

    private String name;

//    private String boatType;

    private String length;

    private String engineId;

    private String enginePower;

    private String maxSpeed;

    private String gps;

    private String radar;

    private String vhf;

    private String fishFinder;

}
