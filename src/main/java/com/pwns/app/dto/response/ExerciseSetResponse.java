package com.pwns.app.dto.response;

import lombok.Builder;

@Builder
public record ExerciseSetResponse(
        Long id,
        Long workoutExerciseId,
        int setNumberIndex,
        float weight,
        int reps,
        int repsInReserve,
        String notes
) {
}
