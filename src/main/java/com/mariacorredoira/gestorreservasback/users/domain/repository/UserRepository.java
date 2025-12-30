package com.mariacorredoira.gestorreservasback.users.domain.repository;

import com.mariacorredoira.gestorreservasback.shared.PageResponse;
import com.mariacorredoira.gestorreservasback.users.domain.entity.User;

public interface UserRepository {
    User save(User user);
    User update(User user);

    void delete(Long id);

    User getById(Long id);

    boolean existsByEmail(String email);
    User getByEmail(String username);
    PageResponse<User> findByFilters(String name, String firstSurname, String secondSurname, Integer page, Integer size);
}
