package com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.mapper;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.entity.ActivityEntity;

import java.util.ArrayList;
import java.util.List;

public class ActivityInfrastructureMapper {
    public static ActivityEntity toActivityEntity(Activity activity) {
        return new ActivityEntity(activity.getId(), activity.getName(), activity.getDescription(), activity.getDate(), activity.getCapacity(), activity.getImage(), activity.getPrice());
    }

    public static Activity toActivityDomain(ActivityEntity activity) {
        return new Activity(activity.getId(), activity.getName(), activity.getDescription(), activity.getDate(), activity.getCapacity(), activity.getImage(), activity.getPrice());
    }

    public static List<Activity> toActivitiesDomain(List<ActivityEntity> activities) {
        List<Activity> domains = new ArrayList<>();
        for (ActivityEntity activityEntity : activities) {
            domains.add(toActivityDomain(activityEntity));
        }
        return domains;
    }
}
