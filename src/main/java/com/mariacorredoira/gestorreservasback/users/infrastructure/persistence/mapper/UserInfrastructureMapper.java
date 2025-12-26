package com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.mapper;

import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserInfrastructureMapper {
    public static UserEntity toUserEntity(User user, PasswordEncoder passwordEncoder) {
        return new UserEntity(user.getId(), user.getName(), user.getFirstSurname(), user.getSecondSurname(), user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRole());
    }

    public static User toUserDomain(UserEntity user) {
        return new User(user.getId(), user.getName(), user.getFirstSurname(), user.getSecondSurname(), user.getEmail(), user.getPassword(), user.getRole());
    }
}
