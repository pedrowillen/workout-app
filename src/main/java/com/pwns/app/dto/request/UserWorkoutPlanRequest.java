package com.pwns.app.dto.request;

import com.pwns.app.utils.TrainingType;
import lombok.Builder;

@Builder
public record UserWorkoutPlanRequest(
        Long userId,
        int periodizationWeeks,
        String trainingType
) { }
