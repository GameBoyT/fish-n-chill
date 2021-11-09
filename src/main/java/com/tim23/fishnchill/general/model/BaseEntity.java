package com.tim23.fishnchill.general.model;

import com.tim23.fishnchill.general.model.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EntityType type;

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Tag> tags = new HashSet<>();
}

