package com.tim23.fishnchill.user.model;

import com.tim23.fishnchill.house.model.House;
import com.tim23.fishnchill.house.model.Rating;
import com.tim23.fishnchill.house.model.Room;
import com.tim23.fishnchill.house.model.Tag;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class HouseOwner extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<House> houses = new HashSet<House>();

    @ManyToMany
    @JoinTable(name = "tags", joinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Rating> rating = new HashSet<Rating>();


}
