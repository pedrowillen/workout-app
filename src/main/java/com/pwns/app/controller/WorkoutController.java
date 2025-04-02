package com.pwns.app.controller;

import com.pwns.app.dto.request.WorkoutRequest;
import com.pwns.app.dto.response.WorkoutResponse;
import com.pwns.app.entity.User;
import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.entity.Workout;
import com.pwns.app.exception.UserNotFoundException;
import com.pwns.app.exception.WorkoutPlanNotFoundForUserException;
import com.pwns.app.mapper.WorkoutMapper;
import com.pwns.app.service.UserService;
import com.pwns.app.service.UserWorkoutPlanService;
import com.pwns.app.service.WorkoutService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;
    private final UserService userService;
    private final UserWorkoutPlanService workoutPlanService;

    @GetMapping
    public ResponseEntity<List<WorkoutResponse>> getWorkoutsByUserId (@RequestParam("userId") Long userId) {
        Optional<User> user = Optional.ofNullable(userService.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId)));


        List<WorkoutResponse> workouts = workoutService.findWorkoutsByUserId(userId)
                .stream()
                .map(WorkoutMapper::toWorkoutResponse)
                .toList();

        return ResponseEntity.ok(workouts);

    }

    @PostMapping("/create")
    public ResponseEntity<WorkoutResponse> createWorkout (@RequestBody WorkoutRequest request) {
        Optional<User> user = Optional.ofNullable(userService.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId())));

        UserWorkoutPlan userWorkoutPlan = Optional.ofNullable(workoutPlanService.findByUserId(request.userId()))
                .orElseThrow(() -> new WorkoutPlanNotFoundForUserException(request.userId()));

        Workout createdWorkout = workoutService.save(WorkoutMapper.toWorkout(request, userWorkoutPlan));

        return ResponseEntity.ok(WorkoutMapper.toWorkoutResponse(createdWorkout));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        workoutService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
