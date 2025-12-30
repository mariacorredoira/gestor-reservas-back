package com.mariacorredoira.gestorreservasback.activities.application;

import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.domain.repository.ActivityRepository;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.mapper.ActivityControllerMapper;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityDetailResponse;
import com.mariacorredoira.gestorreservasback.reservations.domain.repository.ReservationRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GetActivityUseCase {
    private final ActivityRepository activityRepository;
    private final ReservationRepository reservationRepository;

    public List<ActivityDetailResponse> execute(Long idUser) {
        List<Activity> activities = activityRepository.getAll();
        List<ActivityDetailResponse> activityDetailResponses = new ArrayList<>();
        for (Activity activity : activities) {
            boolean existsReservation = reservationRepository.existsReservation(idUser, activity.getId());
            boolean canReserve = existsReservation ? false : true;
            activityDetailResponses.add(ActivityControllerMapper.toActivityDetailResponse(activity, canReserve));
        }
        return activityDetailResponses;
    }
}
