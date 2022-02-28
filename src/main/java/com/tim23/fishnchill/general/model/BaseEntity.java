package com.tim23.fishnchill.general.model;

import com.tim23.fishnchill.general.model.enums.EntityType;
import com.tim23.fishnchill.user.model.BusinessOwner;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EntityType type;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer capacity;

    private String rules;

    private String cancellationTerms;

    private Double rating;

    //TODO mozda neki availability za dostupnoste, kao neka lista parova datuma od kojeg do kojeg je slobodan

    //TODO Cjenovnik

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BusinessOwner owner;

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Image> images = new HashSet<>();
}

