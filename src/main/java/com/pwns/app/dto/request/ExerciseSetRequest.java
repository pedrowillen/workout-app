package com.pwns.app.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ExerciseSetRequest(
        @NotNull Long workoutExerciseId,
        @NotNull int setNumberIndex,
        @NotNull float weight,
        @NotNull int reps,
        @NotNull int repsInReserve,
        String notes
) {
}
