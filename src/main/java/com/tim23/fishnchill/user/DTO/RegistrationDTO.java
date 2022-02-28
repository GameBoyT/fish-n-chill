package com.tim23.fishnchill.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
}
