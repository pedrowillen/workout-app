package com.pwns.app.service;

import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.repository.UserWorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserWorkoutPlanService {

    private final UserWorkoutPlanRepository workoutPlanRepository;

    public UserWorkoutPlan save(UserWorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }
}
