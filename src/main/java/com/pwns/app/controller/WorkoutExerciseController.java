package com.pwns.app.controller;

import com.pwns.app.dto.request.WorkoutExerciseRequest;
import com.pwns.app.dto.response.WorkoutExerciseResponse;
import com.pwns.app.entity.Workout;
import com.pwns.app.entity.WorkoutExercise;
import com.pwns.app.exception.WorkoutNotFoundException;
import com.pwns.app.mapper.WorkoutExerciseMapper;
import com.pwns.app.repository.WorkoutRepository;
import com.pwns.app.service.WorkoutExerciseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workout_exercises")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;
    private final WorkoutRepository workoutRepo;

    @PostMapping("/create")
    public ResponseEntity<WorkoutExerciseResponse> create(@RequestBody WorkoutExerciseRequest request) {
        Workout workout = workoutRepo.findById(request.workoutId())
                .orElseThrow(() -> new WorkoutNotFoundException(request.workoutId()));

        WorkoutExercise workoutExercise = workoutExerciseService.save(WorkoutExerciseMapper.toWorkoutExercise(request, workout));

        WorkoutExerciseResponse workoutExerciseResponse = WorkoutExerciseMapper.toWorkoutExerciseResponse(workoutExercise);

        return ResponseEntity.ok(workoutExerciseResponse);
    }

    @GetMapping("/exercises")
    public ResponseEntity<List<WorkoutExerciseResponse>> findWorkoutExercisesByWorkoutId(@RequestParam("workoutId") Long workoutId) {
        Optional<Workout> workout = Optional.ofNullable(workoutRepo.findById(workoutId)
                .orElseThrow(() -> new WorkoutNotFoundException(workoutId)));

        List<WorkoutExercise> workoutExercises = workout.get().getWorkoutExercises();
        System.out.println(workoutExercises);

        List<WorkoutExerciseResponse> workoutExerciseResponses = workoutExercises
                .stream()
                .map(WorkoutExerciseMapper::toWorkoutExerciseResponse)
                .toList();

        return ResponseEntity.ok(workoutExerciseResponses);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        workoutExerciseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
