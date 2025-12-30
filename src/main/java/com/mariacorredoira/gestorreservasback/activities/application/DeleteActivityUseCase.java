package com.mariacorredoira.gestorreservasback.activities.application;

import com.mariacorredoira.gestorreservasback.activities.application.exceptions.ActivityNotFoundException;
import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.entity.ActivityEntity;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteActivityUseCase {
    private final ActivityRepository activityRepository;

    public void execute(Long id) {
        Activity activityOpt = activityRepository.getById(id);
        if (activityOpt == null) {
            throw new ActivityNotFoundException(id);
        }
        activityRepository.delete(id);
    }
}
