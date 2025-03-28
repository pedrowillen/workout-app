package com.pwns.app.dto.response;

import com.pwns.app.utils.WorkoutTechnique;
import lombok.Builder;

@Builder
public record WorkoutResponse(
        String workoutName,
        String workoutDesc,
        WorkoutTechnique workoutTechnique
) { }
