package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.mapper.UserDomainMapper;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository userRepository;

    public User execute(Long id, UserRequest request) {
        User userId = userRepository.getById(id);
        if (userId == null) {
            throw new UserNotFoundException(String.valueOf(id));
        }
        User user = UserDomainMapper.toUserDomain(id, request);
        user = userRepository.update(user);
        return user;
    }
}
