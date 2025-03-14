package com.pwns.app.repository;

import com.pwns.app.entity.UserWorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkoutPlanRepository extends JpaRepository<UserWorkoutPlan, Long> {
}
