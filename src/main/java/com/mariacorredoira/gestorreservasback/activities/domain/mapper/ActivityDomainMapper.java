package com.mariacorredoira.gestorreservasback.activities.domain.mapper;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.request.ActivityRequest;

public class ActivityDomainMapper {
    public static Activity toActivityDomain(Long id, ActivityRequest request) {
        return new Activity(id, request.getName(), request.getDescription(), request.getDate(), request.getCapacity(), request.getImage(), request.getPrice());
    }
}
