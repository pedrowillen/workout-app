package com.pwns.app.mapper;

import com.pwns.app.dto.request.ExerciseSetRequest;
import com.pwns.app.dto.request.WorkoutExerciseRequest;
import com.pwns.app.dto.response.ExerciseSetResponse;
import com.pwns.app.dto.response.WorkoutExerciseResponse;
import com.pwns.app.entity.ExerciseSet;
import com.pwns.app.entity.Workout;
import com.pwns.app.entity.WorkoutExercise;
import lombok.experimental.UtilityClass;
import org.antlr.v4.runtime.atn.LexerCustomAction;

@UtilityClass
public class ExerciseSetMapper {
    public static ExerciseSet toExerciseSet(ExerciseSetRequest request, WorkoutExercise workoutExercise) {
        return ExerciseSet.builder()
                .exercise(workoutExercise)
                .setNumberIndex(request.setNumberIndex())
                .weight(request.weight())
                .reps(request.reps())
                .repsInReserve(request.repsInReserve())
                .notes(request.notes())
                .build();
    }

    public static ExerciseSetResponse toExerciseSetResponse(ExerciseSet exerciseSet) {
        return ExerciseSetResponse.builder()
                .id(exerciseSet.getId())
                .workoutExerciseId(exerciseSet.getExercise().getId())
                .setNumberIndex(exerciseSet.getSetNumberIndex())
                .weight(exerciseSet.getWeight())
                .reps(exerciseSet.getReps())
                .repsInReserve(exerciseSet.getRepsInReserve())
                .notes(exerciseSet.getNotes())
                .build();
    }
}
