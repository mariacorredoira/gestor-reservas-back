package com.mariacorredoira.gestorreservasback.users.infrastructure.controller.mapper;

import com.mariacorredoira.gestorreservasback.shared.PageResponse;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.LoginResponse;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserDetailResponse;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserControllerMapper {
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId());
    }
    public static LoginResponse toLoginResponse(String token) {
        return new LoginResponse(token);
    }
    public static UserDetailResponse toUserDetailResponse(User user) {
        return new UserDetailResponse(user.getId(), user.getName(), user.getFirstSurname(), user.getSecondSurname(), user.getEmail(), user.getRole());
    }

    public static List<UserDetailResponse> toUserResponseList(List<User> users) {
        List<UserDetailResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(toUserDetailResponse(user));
        }
        return responses;
    }

    public static PageResponse<UserDetailResponse> toUserResponsePage(PageResponse<User> users) {
        List<UserDetailResponse> userDetailResponses = toUserResponseList(users.getData());
        PageResponse<UserDetailResponse> responses = new PageResponse<>(userDetailResponses, users.getPage(), users.getTotal());
        return responses;
    }
}
