package com.pwns.app.controller;

import com.pwns.app.dto.request.ExerciseSetRequest;
import com.pwns.app.dto.response.ExerciseSetResponse;
import com.pwns.app.entity.ExerciseSet;
import com.pwns.app.entity.Workout;
import com.pwns.app.entity.WorkoutExercise;
import com.pwns.app.exception.WorkoutExerciseNotFoundException;
import com.pwns.app.exception.WorkoutNotFoundException;
import com.pwns.app.mapper.ExerciseSetMapper;
import com.pwns.app.repository.WorkoutExerciseRepository;
import com.pwns.app.service.ExerciseSetService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exercise_sets")
public class ExerciseSetController {
    private final ExerciseSetService exerciseSetService;
    private final WorkoutExerciseRepository workoutExerciseRepo;

    @PostMapping("/create")
    public ResponseEntity<ExerciseSetResponse> create(@RequestBody ExerciseSetRequest request) {
        WorkoutExercise workoutExercise = workoutExerciseRepo.findById(request.workoutExerciseId())
                .orElseThrow(() -> new WorkoutExerciseNotFoundException(request.workoutExerciseId()));

        ExerciseSet exerciseSet = exerciseSetService.save(ExerciseSetMapper.toExerciseSet(request, workoutExercise));

        ExerciseSetResponse exerciseSetResponse = ExerciseSetMapper.toExerciseSetResponse(exerciseSet);

        return ResponseEntity.ok(exerciseSetResponse);
    }

    @GetMapping("/sets")
    public ResponseEntity<List<ExerciseSetResponse>> findSetsByWorkoutExerciseId(@RequestParam("workoutExerciseId") Long workoutExerciseId) {
        Optional<WorkoutExercise> workoutExercise = Optional.ofNullable(workoutExerciseRepo.findById(workoutExerciseId)
                .orElseThrow(() -> new WorkoutNotFoundException(workoutExerciseId)));

        List<ExerciseSet> exerciseSets = workoutExercise.get().getSets();

        List<ExerciseSetResponse> exerciseSetResponses = exerciseSets.stream()
                .map(ExerciseSetMapper::toExerciseSetResponse)
                .toList();

        return ResponseEntity.ok(exerciseSetResponses);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        exerciseSetService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
