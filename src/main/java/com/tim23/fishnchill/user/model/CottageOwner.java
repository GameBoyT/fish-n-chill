package com.tim23.fishnchill.user.model;

import com.tim23.fishnchill.cottage.model.Cottage;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CottageOwner extends User {

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cottage> cottages = new HashSet<>();

//    @ManyToMany
//    @JoinTable(name = "tags", joinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
//    private Set<Rating> rating = new HashSet<Rating>();
}
