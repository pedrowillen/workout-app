package com.pwns.app.dto.response;

import com.pwns.app.utils.TrainingType;
import lombok.Builder;

@Builder
public record UserWorkoutPlanResponse(
        UserResponse userResponse,
        int periodizationWeeks,
        TrainingType trainingType
) { }
