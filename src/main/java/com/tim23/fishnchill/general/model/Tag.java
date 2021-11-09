package com.tim23.fishnchill.general.model;

import com.tim23.fishnchill.user.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    private Long id;

    private String tag;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BaseEntity entity;
}
