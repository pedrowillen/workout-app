package com.pwns.app.service;

import com.pwns.app.entity.Workout;
import com.pwns.app.mapper.WorkoutMapper;
import com.pwns.app.repository.WorkoutRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public List<Workout> findWorkoutsByUserId(Long userId) {
        return workoutRepository.findByUserWorkoutPlan_User_Id(userId);
    }

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Transactional
    public void deleteById(Long id) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found."));

        workoutRepository.delete(workout);
    }
}
