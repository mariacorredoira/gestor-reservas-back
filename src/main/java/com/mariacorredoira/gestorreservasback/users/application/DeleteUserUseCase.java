package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserUseCase {
    private final UserRepository userRepository;

    public void execute(Long id) {

        User user = userRepository.getById(id);
        if (user == null) {
            throw new UserNotFoundException(String.valueOf(id));
        }
        userRepository.delete(id);
    }
}
