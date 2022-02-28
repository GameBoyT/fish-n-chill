package com.tim23.fishnchill.cottage.model;

import com.tim23.fishnchill.general.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cottage extends BaseEntity {

    private String address;

    @OneToMany(mappedBy = "cottage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();
}
