package com.tim23.fishnchill.user.model;

import com.tim23.fishnchill.adventure.Adventure;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class AdventureOwner extends User {
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Adventure> adventures;
}
