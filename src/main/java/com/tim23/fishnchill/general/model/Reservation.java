package com.tim23.fishnchill.general.model;

import com.tim23.fishnchill.user.model.User;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private LocalDateTime start;
//
//    private LocalDateTime end;

    private Integer duration;

    private Integer maximalGuests;

    private Double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BaseEntity entity;
}
