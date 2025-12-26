package com.mariacorredoira.gestorreservasback.users.domain.repository;

import com.mariacorredoira.gestorreservasback.users.domain.entity.User;

public interface UserRepository {
    User save(User user);

    User getByEmail(String username);
}
