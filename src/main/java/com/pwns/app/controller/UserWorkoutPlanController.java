package com.pwns.app.controller;

import com.pwns.app.dto.request.UserWorkoutPlanRequest;
import com.pwns.app.dto.response.UserWorkoutPlanResponse;
import com.pwns.app.entity.User;
import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.exception.UserNotFoundException;
import com.pwns.app.mapper.UserWorkoutPlanMapper;
import com.pwns.app.repository.UserRepository;
import com.pwns.app.service.UserWorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users_workout_plans")
public class UserWorkoutPlanController {

    private final UserRepository userRepository;
    private final UserWorkoutPlanService workoutPlanService;

    @PostMapping("/create")
    public ResponseEntity<UserWorkoutPlanResponse> create(@RequestBody UserWorkoutPlanRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId()));

        UserWorkoutPlan workoutPlan = workoutPlanService.save(UserWorkoutPlanMapper.toUserWorkoutPlan(request, user));
        System.out.println(workoutPlan);

        UserWorkoutPlanResponse workoutPlanResponse = UserWorkoutPlanMapper.toUserWorkoutPlanResponse(workoutPlan);

        return ResponseEntity.ok(workoutPlanResponse);
    }
}
