package com.tim23.fishnchill.cottage;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CottageDTO {
    private Long id;

    private String name;

    private String address;

    private String description;
}
