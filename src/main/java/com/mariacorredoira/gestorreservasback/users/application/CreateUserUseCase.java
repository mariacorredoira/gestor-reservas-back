package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.mapper.UserDomainMapper;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.UserRequest;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User execute(UserRequest request) {
        User user = UserDomainMapper.toUserDomain(null, request);
        user = userRepository.save(user);
        return user;
    }
}
