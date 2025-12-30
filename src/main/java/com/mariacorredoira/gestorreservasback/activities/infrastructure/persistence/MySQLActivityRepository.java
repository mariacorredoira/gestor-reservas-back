package com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence;

import com.mariacorredoira.gestorreservasback.activities.application.exceptions.ActivityNotFoundException;
import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.entity.ActivityEntity;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.mapper.ActivityInfrastructureMapper;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.persistence.spring.SpringActivityRepository;
import com.mariacorredoira.gestorreservasback.users.application.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MySQLActivityRepository implements ActivityRepository {
    private final SpringActivityRepository springActivityRepository;

    @Override
    public Activity save(Activity activity) {
        ActivityEntity activityEntity = ActivityInfrastructureMapper.toActivityEntity(activity);
        activityEntity = springActivityRepository.save(activityEntity);
        activity = ActivityInfrastructureMapper.toActivityDomain(activityEntity);
        return activity;
    }

    @Override
    public Activity update(Activity activity) {
        ActivityEntity activityEntity = ActivityInfrastructureMapper.toActivityEntity(activity);
        activityEntity = springActivityRepository.save(activityEntity);
        activity = ActivityInfrastructureMapper.toActivityDomain(activityEntity);
        return activity;
    }

    @Override
    public void delete(Long id) {

        springActivityRepository.deleteById(id);
    }


    @Override
    public List<Activity> getAll() {
        List<ActivityEntity> activityEntities = springActivityRepository.findAll();
        List<Activity> activities = ActivityInfrastructureMapper.toActivitiesDomain(activityEntities);
        return activities;
    }

    @Override
    public Activity getById(Long idActivity) {
        Optional<ActivityEntity> activityOpt = springActivityRepository.findById(idActivity);
        Activity activity = ActivityInfrastructureMapper.toActivityDomain(activityOpt.get());
        return activity;
    }

}
