package com.mariacorredoira.gestorreservasback.users.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class User {
    private Long id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String email;
    private String password;
    private String role;

    public User(Long id) {
        this.id = id;
    }

}
