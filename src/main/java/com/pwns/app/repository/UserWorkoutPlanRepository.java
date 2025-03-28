package com.pwns.app.repository;

import com.pwns.app.entity.UserWorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserWorkoutPlanRepository extends JpaRepository<UserWorkoutPlan, Long> {
    UserWorkoutPlan findByUserId(Long userId);
}
