package com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.spring;

import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringActivityRepository extends JpaRepository<ActivityEntity, Long> {
}