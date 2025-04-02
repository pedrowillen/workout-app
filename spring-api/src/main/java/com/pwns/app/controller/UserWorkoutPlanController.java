package com.pwns.app.controller;

import com.pwns.app.dto.request.UserWorkoutPlanRequest;
import com.pwns.app.dto.response.UserWorkoutPlanResponse;
import com.pwns.app.entity.User;
import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.exception.UserNotFoundException;
import com.pwns.app.exception.WorkoutPlanNotFoundForUserException;
import com.pwns.app.mapper.UserWorkoutPlanMapper;
import com.pwns.app.repository.UserRepository;
import com.pwns.app.service.UserService;
import com.pwns.app.service.UserWorkoutPlanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users_workout_plans")
public class UserWorkoutPlanController {

    private final UserRepository userRepository;
    private final UserWorkoutPlanService workoutPlanService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserWorkoutPlanResponse> create(@RequestBody UserWorkoutPlanRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId()));

        UserWorkoutPlan workoutPlan = workoutPlanService.save(UserWorkoutPlanMapper.toUserWorkoutPlan(request, user));
        System.out.println(workoutPlan);

        UserWorkoutPlanResponse workoutPlanResponse = UserWorkoutPlanMapper.toUserWorkoutPlanResponse(workoutPlan);

        return ResponseEntity.ok(workoutPlanResponse);
    }

    @GetMapping()
    public ResponseEntity<List<UserWorkoutPlanResponse>> getAll() {
        List<UserWorkoutPlanResponse> workoutPlanResponses = workoutPlanService.findAll()
                .stream()
                .map(UserWorkoutPlanMapper::toUserWorkoutPlanResponse)
                .toList();

        return ResponseEntity.ok(workoutPlanResponses);
    }

    @GetMapping("/by_user")
    public ResponseEntity<UserWorkoutPlanResponse> findPlanByUserId(@RequestParam("userId") Long userId) {
        Optional<User> user = Optional.ofNullable(userService.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId)));

        UserWorkoutPlan userWorkoutPlan = Optional.ofNullable(workoutPlanService.findByUserId(userId))
                .orElseThrow(() -> new WorkoutPlanNotFoundForUserException(userId));

        UserWorkoutPlanResponse workoutPlanResponse = UserWorkoutPlanMapper.toUserWorkoutPlanResponse(userWorkoutPlan);

        return ResponseEntity.ok(workoutPlanResponse);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        workoutPlanService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
