package com.pwns.app.service;

import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.entity.Workout;
import com.pwns.app.entity.WorkoutExercise;
import com.pwns.app.exception.WorkoutPlanNotFoundException;
import com.pwns.app.repository.ExerciseSetRepository;
import com.pwns.app.repository.UserWorkoutPlanRepository;
import com.pwns.app.repository.WorkoutExerciseRepository;
import com.pwns.app.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserWorkoutPlanService {

    private final UserWorkoutPlanRepository workoutPlanRepository;
    private final WorkoutRepository workoutRepo;
    private final ExerciseSetRepository exerciseSetRepo;
    private final WorkoutExerciseRepository workoutExerciseRepo;

    public UserWorkoutPlan save(UserWorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }

    @Transactional
    public void deleteWorkoutPlanById(Long id) {
        workoutPlanRepository.deleteById(id);
        workoutPlanRepository.flush();
    }

    public List<UserWorkoutPlan> findAll() {
        return workoutPlanRepository.findAll();
    }

    public UserWorkoutPlan findByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }
}
