package com.tim23.fishnchill.cottage.model;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.reservation.model.CottageReservation;
import com.tim23.fishnchill.user.model.CottageOwner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cottage extends BaseEntity {

    private String address;

    private Integer capacity;

    @OneToMany(mappedBy = "cottage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CottageReservation> cottageReservations;

    @OneToMany(mappedBy = "cottage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CottageOwner owner;
}
