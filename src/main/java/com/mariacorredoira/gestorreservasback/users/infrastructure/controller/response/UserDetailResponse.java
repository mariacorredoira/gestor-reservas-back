package com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResponse {
    private long id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String email;
    private String role;
}
