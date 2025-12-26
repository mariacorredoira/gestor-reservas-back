package com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.spring;

import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
