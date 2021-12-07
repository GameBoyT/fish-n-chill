package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.general.DTO.ImageDTO;
import com.tim23.fishnchill.general.model.Image;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageDTO {
    private Long id;

    private String name;

    private String address;

    private String description;

    private Set<ImageDTO> images = new HashSet<>();
}
