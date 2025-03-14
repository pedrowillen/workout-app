package com.pwns.app.mapper;

import com.pwns.app.dto.request.UserRequest;
import com.pwns.app.dto.request.UserWorkoutPlanRequest;
import com.pwns.app.dto.response.UserResponse;
import com.pwns.app.dto.response.UserWorkoutPlanResponse;
import com.pwns.app.entity.User;
import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.utils.Sex;
import com.pwns.app.utils.TrainingType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserWorkoutPlanMapper {
    public static UserWorkoutPlan toUserWorkoutPlan(UserWorkoutPlanRequest request, User user) {
        return UserWorkoutPlan.builder()
                .user(user)
                .periodizationWeeks(request.periodizationWeeks())
                .trainingType(TrainingType.valueOf(request.trainingType()))
                .build();
    }

    public static UserWorkoutPlanResponse toUserWorkoutPlanResponse(UserWorkoutPlan userWorkoutPlan) {
        return UserWorkoutPlanResponse.builder()
                .userResponse(UserMapper.toUserResponse(userWorkoutPlan.getUser()))
                .periodizationWeeks(userWorkoutPlan.getPeriodizationWeeks())
                .trainingType(userWorkoutPlan.getTrainingType())
                .build();
    }
}
