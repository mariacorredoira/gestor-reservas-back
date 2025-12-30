package com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.mapper;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityDetailResponse;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityResponse;

public class ActivityControllerMapper {
    public static ActivityResponse toActivityResponse(Activity activity) {
        return new ActivityResponse(activity.getId());
    }

    public static ActivityDetailResponse toActivityDetailResponse(Activity activity, boolean canReserve) {
        return new ActivityDetailResponse(activity.getId(), activity.getName(), activity.getDescription(), activity.getDate(), activity.getCapacity(), activity.getImage(), activity.getPrice() ,canReserve );
    }
}
