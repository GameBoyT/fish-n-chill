package com.tim23.fishnchill.user.model;

import com.tim23.fishnchill.boat.model.Boat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class BoatOwner extends User {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Boat> boats;
}
