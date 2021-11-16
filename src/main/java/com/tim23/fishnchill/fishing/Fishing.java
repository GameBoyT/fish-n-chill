package com.tim23.fishnchill.fishing;

import com.tim23.fishnchill.general.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fishing extends BaseEntity {

    private String biography;

    //TODO Pecaroska oprema
}
