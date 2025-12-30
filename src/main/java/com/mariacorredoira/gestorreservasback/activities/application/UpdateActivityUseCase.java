package com.mariacorredoira.gestorreservasback.activities.application;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.mapper.ActivityDomainMapper;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.request.ActivityRequest;
import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UpdateActivityUseCase {
    private final ActivityRepository activityRepository;

    public Activity execute(Long id, ActivityRequest request) {
        Activity activityOpt = activityRepository.getById(id);
        if (activityOpt == null) {
            throw new UserNotFoundException(String.valueOf(id));
        }
        Activity activity = ActivityDomainMapper.toActivityDomain(id, request);
        activity = activityRepository.update(activity);
        return activity;
    }
}
