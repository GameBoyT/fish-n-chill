package com.tim23.fishnchill.cottage.model;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.general.model.Rating;
import com.tim23.fishnchill.general.model.Reservation;
import com.tim23.fishnchill.general.model.Tag;
import com.tim23.fishnchill.general.model.enums.EntityType;
import com.tim23.fishnchill.user.model.CottageOwner;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cottage extends BaseEntity {
//    @Id
//    private Long id;

    private String name;

    private String address;

    private String description;

    //TODO image storage, probably a list of strings (urls)
//    public Images;

    @OneToMany(mappedBy = "cottage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<Room>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CottageOwner owner;

    public Cottage(Long id, EntityType type, Set<Rating> ratings, Set<Reservation> reservations, Set<Tag> tags, String name, String address, String description, Set<Room> rooms, CottageOwner owner) {
        super(id, type, ratings, reservations, tags);
        this.name = name;
        this.address = address;
        this.description = description;
        this.rooms = rooms;
        this.owner = owner;
    }

    public Cottage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public CottageOwner getOwner() {
        return owner;
    }

    public void setOwner(CottageOwner owner) {
        this.owner = owner;
    }
}
