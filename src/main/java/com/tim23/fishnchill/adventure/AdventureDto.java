package com.tim23.fishnchill.adventure;

import com.tim23.fishnchill.general.model.Image;
import com.tim23.fishnchill.general.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdventureDto {
    private Long id;

    private String name;

    private String description;

    private Integer capacity;

    private String rules;

    private String cancellationTerms;

    private Double rating;

    private String biography;

    private Long ownerId;

    private Set<Image> images = new HashSet<>();

    private Set<Tag> tags = new HashSet<>();
}
