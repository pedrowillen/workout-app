package com.pwns.app.service;

import com.pwns.app.entity.Workout;
import com.pwns.app.mapper.WorkoutMapper;
import com.pwns.app.repository.WorkoutRepository;
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
}
