package com.pwns.app.service;

import com.pwns.app.entity.WorkoutExercise;
import com.pwns.app.repository.WorkoutExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutExerciseService {
    private final WorkoutExerciseRepository workoutExerciseRepo;

    public WorkoutExercise save(WorkoutExercise workoutExercise) {
        return workoutExerciseRepo.save(workoutExercise);
    }
}
