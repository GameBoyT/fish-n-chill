package com.tim23.fishnchill.boat;

import com.tim23.fishnchill.general.model.Image;
import com.tim23.fishnchill.general.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoatDto {
    private Long id;

    private String name;

    private String description;

    private Integer capacity;

    private String rules;

    private String cancellationTerms;

    private Double rating;

    private Long ownerId;

    private Long boatSpecificationId;

    private String boatEnginePower;

    private Set<Image> images;

    private Set<Tag> tags;
}
