package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.general.DTO.ImageDto;
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
public class CottageDto {
    private Long id;

    private String name;

    private String address;

    private String description;

    private Set<ImageDto> images = new HashSet<>();
}
