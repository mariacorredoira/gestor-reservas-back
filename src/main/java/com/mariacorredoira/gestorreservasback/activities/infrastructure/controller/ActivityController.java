package com.mariacorredoira.gestorreservasback.activities.infrastructure.controller;

import com.mariacorredoira.gestorreservasback.activities.application.*;
import com.mariacorredoira.gestorreservasback.activities.domain.entity.Activity;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.mapper.ActivityControllerMapper;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.request.ActivityRequest;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityDetailResponse;
import com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.response.ActivityResponse;
import com.mariacorredoira.gestorreservasback.security.SecurityUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@AllArgsConstructor
public class ActivityController {
    private final CreateActivityUseCase createActivityUseCase;
    private final UpdateActivityUseCase updateActivityUseCase;
    private final DeleteActivityUseCase deleteActivityUseCase;
    private final GetActivityUseCase getActivityUseCase;
    private final GetActivityByIdUseCase getActivityByIdUseCase;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ActivityResponse> saveActivity(@RequestBody @Valid ActivityRequest request) {
        Activity activity = createActivityUseCase.execute(request);
        ActivityResponse activityResponse = ActivityControllerMapper.toActivityResponse(activity);
        return ResponseEntity.ok(activityResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityResponse> updateActivity(@PathVariable long id, @RequestBody @Valid ActivityRequest request) {
        Activity activity = updateActivityUseCase.execute(id, request);
        ActivityResponse activityResponse = ActivityControllerMapper.toActivityResponse(activity);
        return ResponseEntity.ok(activityResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable long id) {
        deleteActivityUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ActivityDetailResponse>> getAllActivity(@AuthenticationPrincipal SecurityUser securityUser) {
        Long idUser = securityUser.getUser().getId();
        List<ActivityDetailResponse> activityResponses = getActivityUseCase.execute(idUser);
        return ResponseEntity.ok(activityResponses);
    }

    @GetMapping("/{idActivity}")
    public ResponseEntity<ActivityDetailResponse> getActivityById(@PathVariable long idActivity, @AuthenticationPrincipal SecurityUser securityUser) {
        Long idUser = securityUser.getUser().getId();
        ActivityDetailResponse activityDetailResponse = getActivityByIdUseCase.execute(idActivity, idUser);
        return ResponseEntity.ok(activityDetailResponse);
    }
}
