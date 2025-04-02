package com.pwns.app.repository;

import com.pwns.app.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserWorkoutPlan_User_Id(Long userId);
}
