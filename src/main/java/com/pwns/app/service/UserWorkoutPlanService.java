package com.pwns.app.service;

import com.pwns.app.entity.UserWorkoutPlan;
import com.pwns.app.repository.ExerciseSetRepository;
import com.pwns.app.repository.UserWorkoutPlanRepository;
import com.pwns.app.repository.WorkoutExerciseRepository;
import com.pwns.app.repository.WorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public void deleteById(Long id) {
        UserWorkoutPlan plan = workoutPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workout plan not found"));

        if (plan.getUser() != null) {
            plan.getUser().setWorkoutPlan(null);
        }

        workoutPlanRepository.delete(plan);
    }

    public List<UserWorkoutPlan> findAll() {
        return workoutPlanRepository.findAll();
    }

    public UserWorkoutPlan findByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }
}
