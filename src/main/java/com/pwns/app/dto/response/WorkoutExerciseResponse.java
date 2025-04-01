package com.pwns.app.dto.response;

import lombok.Builder;

@Builder
public record WorkoutExerciseResponse(
        Long id,
        Long workoutId,
        String exerciseName,
        int intervalSeconds,
        int setsQuantity,
        String observation
) {
}
