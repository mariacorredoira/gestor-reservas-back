package com.mariacorredoira.gestorreservasback.activities.application;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.mapper.ActivityDomainMapper;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.request.ActivityRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateActivityUseCase {
    private final ActivityRepository activityRepository;

    public Activity execute(ActivityRequest request) {
        Activity activity = ActivityDomainMapper.toActivityDomain(null, request);
        activity = activityRepository.save(activity);
        return activity;
    }
}
