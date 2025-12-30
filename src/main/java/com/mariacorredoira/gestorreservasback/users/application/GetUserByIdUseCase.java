package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public User execute(Long id) {
        User userId = userRepository.getById(id);
        if (userId == null) {
            throw new UserNotFoundException(String.valueOf(id));
        }
        User user = userRepository.getById(id);
        return user;
    }
}
