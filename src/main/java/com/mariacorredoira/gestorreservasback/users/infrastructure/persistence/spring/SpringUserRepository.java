package com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.spring;

import com.mariacorredoira.gestorreservasback.users.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

    @Query("""
                SELECT u FROM UserEntity u
                WHERE (:name IS NULL OR u.name LIKE CONCAT('%', :name, '%'))
                  AND (:firstSurname IS NULL OR u.firstSurname LIKE CONCAT('%', :firstSurname, '%'))
                  AND (:secondSurname IS NULL OR u.secondSurname LIKE CONCAT('%', :secondSurname, '%'))
            """)
    Page<UserEntity> searchByFilters(@Param("name") String name, @Param("firstSurname") String firstSurname, @Param("secondSurname") String secondSurname, Pageable pageable);
}
