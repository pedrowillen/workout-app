package com.pwns.app.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record WorkoutExerciseRequest(
        @NotNull Long workoutId,
        @NotNull String exerciseName,
        @NotNull int intervalSeconds,
        String observation,
        @NotNull int setsQuantity
) {
}
