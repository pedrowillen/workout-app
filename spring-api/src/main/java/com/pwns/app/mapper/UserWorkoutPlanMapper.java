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

import java.time.LocalDate;

@UtilityClass
public class UserWorkoutPlanMapper {
    public static UserWorkoutPlan toUserWorkoutPlan(UserWorkoutPlanRequest request, User user) {
        LocalDate startDate = request.periodStart() != null ? request.periodStart() : LocalDate.now();

        return UserWorkoutPlan.builder()
                .user(user)
                .periodizationWeeks(request.periodizationWeeks())
                .trainingType(TrainingType.valueOf(request.trainingType()))
                .periodStart(request.periodStart())
                .periodEnd(startDate.plusWeeks(request.periodizationWeeks()))
                .build();
    }

    public static UserWorkoutPlanResponse toUserWorkoutPlanResponse(UserWorkoutPlan userWorkoutPlan) {
        return UserWorkoutPlanResponse.builder()
                .id(userWorkoutPlan.getId())
                .userResponse(UserMapper.toUserResponse(userWorkoutPlan.getUser()))
                .periodizationWeeks(userWorkoutPlan.getPeriodizationWeeks())
                .trainingType(userWorkoutPlan.getTrainingType())
                .periodStart(userWorkoutPlan.getPeriodStart())
                .periodEnd(userWorkoutPlan.getPeriodEnd())
                .build();
    }
}
