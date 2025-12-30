package com.mariacorredoira.gestorreservasback.activities.domain.repository;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;

import java.util.List;

public interface ActivityRepository {
    Activity save(Activity activity);

    Activity update(Activity activity);

    void delete(Long id);

    List<Activity> getAll();

    Activity getById(Long idActivity);
}
