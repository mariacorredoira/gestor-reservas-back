package com.mariacorredoira.gestorreservasback.users.domain.mapper;

import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.UserRequest;

public class UserDomainMapper {
    public static User toUserDomain(Long id, UserRequest request) {
        return new User(id, request.getName(), request.getFirstSurname(), request.getSecondSurname(), request.getEmail(), request.getPassword(), "regular");
    }
}
