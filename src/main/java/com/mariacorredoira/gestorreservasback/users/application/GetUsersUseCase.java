package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.shared.PageResponse;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;
import com.mariacorredoira.gestorreservasback.users.domain.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUsersUseCase {
    private final UserRepository userRepository;

    public PageResponse<User> execute(String name, String firstSurname, String secondSurname, Integer page, Integer size) {
        return userRepository.findByFilters(name, firstSurname, secondSurname, page, size);
    }

}
