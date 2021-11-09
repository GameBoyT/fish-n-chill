package com.tim23.fishnchill.general.model;

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
public class Tag {
    @Id
    private Long id;

    private String tag;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BaseEntity entity;
}
