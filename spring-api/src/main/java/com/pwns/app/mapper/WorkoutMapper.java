package com.pwns.app.mapper;

import com.pwns.app.dto.request.WorkoutRequest;
import com.pwns.app.dto.response.WorkoutResponse;
import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.entity.Workout;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkoutMapper {
    public static Workout toWorkout(WorkoutRequest request, UserWorkoutPlan userWorkoutPlan) {
        return Workout.builder()
                .workoutName(request.workoutName())
                .workoutTechnique(request.workoutTechnique())
                .workoutDescription(request.workoutDescription())
                .userWorkoutPlan(userWorkoutPlan)
                .build();
    }

    public static WorkoutResponse toWorkoutResponse(Workout workout) {
        return WorkoutResponse.builder()
                .workoutName(workout.getWorkoutName())
                .workoutDesc(workout.getWorkoutDescription())
                .workoutTechnique(workout.getWorkoutTechnique())
                .build();
    }
}
