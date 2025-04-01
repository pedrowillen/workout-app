package com.pwns.app.mapper;

import com.pwns.app.dto.request.WorkoutExerciseRequest;
import com.pwns.app.dto.response.WorkoutExerciseResponse;
import com.pwns.app.entity.Workout;
import com.pwns.app.entity.WorkoutExercise;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkoutExerciseMapper {
    public static WorkoutExercise toWorkoutExercise(WorkoutExerciseRequest request, Workout workout) {
        return WorkoutExercise.builder()
                .workout(workout)
                .exerciseName(request.exerciseName())
                .intervalSeconds(request.intervalSeconds())
                .setsQuantity(request.setsQuantity())
                .observation(request.observation())
                .build();
    }

    public static WorkoutExerciseResponse toWorkoutExerciseResponse(WorkoutExercise workoutExercise) {
        return WorkoutExerciseResponse.builder()
                .id(workoutExercise.getId())
                .workoutId(workoutExercise.getWorkout().getId())
                .exerciseName(workoutExercise.getExerciseName())
                .intervalSeconds(workoutExercise.getIntervalSeconds())
                .setsQuantity(workoutExercise.getSetsQuantity())
                .observation(workoutExercise.getObservation())
                .build();
    }
}
