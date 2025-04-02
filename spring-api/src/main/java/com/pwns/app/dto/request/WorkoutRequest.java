package com.pwns.app.dto.request;

import com.pwns.app.utils.WorkoutTechnique;
import lombok.Builder;

@Builder
public record WorkoutRequest(
        Long userId,
        String workoutName,
        String workoutDescription,
        WorkoutTechnique workoutTechnique
) { }
