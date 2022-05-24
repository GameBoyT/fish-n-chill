package com.tim23.fishnchill.adventure;

import com.tim23.fishnchill.general.model.Image;
import com.tim23.fishnchill.general.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    private Double ratingAverage;

    private Integer ratingCount;

    private String biography;

    private BigDecimal price;

    private Long ownerId;

    private LocalDateTime availabilityStart;

    private LocalDateTime availabilityEnd;

    private String address;

    private Set<Image> images;

    private Set<Tag> tags;
}
