package com.tim23.fishnchill.house.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    private Long id;

    private String tag;

//    @ManyToMany(mappedBy = "houses")
//    private Set<House> houses = new HashSet<House>();

}
