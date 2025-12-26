package com.mariacorredoira.gestorreservasback.users.infrastructure.controller.mapper;

import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserResponse;

public class UserControllerMapper {
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId());
    }
}
