package com.tim23.fishnchill.cottage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    private Long id;

    private Integer numberOfBeds;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cottage cottage;
}
