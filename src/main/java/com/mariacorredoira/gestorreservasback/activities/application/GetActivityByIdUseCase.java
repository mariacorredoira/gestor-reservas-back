package com.mariacorredoira.gestorreservasback.activities.application;

import com.mariacorredoira.gestorreservasback.activities.application.exceptions.ActivityNotFoundException;
import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.mapper.ActivityControllerMapper;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityDetailResponse;
import com.mariacorredoira.gestorreservasback.reservations.domain.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class GetActivityByIdUseCase {
    private final ActivityRepository activityRepository;
    private final ReservationRepository reservationRepository;

    public ActivityDetailResponse execute(Long idActivity, Long idUser) {
        Activity activityOpt = activityRepository.getById(idActivity);
        if (activityOpt  == null) {
            throw new ActivityNotFoundException(idActivity);
        }
        Activity activity = activityRepository.getById(idActivity);
        boolean existsReservation = reservationRepository.existsReservation(idUser, activity.getId());
        boolean canReserve = existsReservation ? false : true;
        return ActivityControllerMapper.toActivityDetailResponse(activity, canReserve);
    }
}
