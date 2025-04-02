package com.pwns.app.dto.response;

import com.pwns.app.utils.TrainingType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserWorkoutPlanResponse(
        Long id,
        UserResponse userResponse,
        int periodizationWeeks,
        TrainingType trainingType,
        LocalDate periodStart,
        LocalDate periodEnd
) { }
