package com.pwns.app.entity;

import com.pwns.app.utils.WorkoutTechnique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_name", length = 20, nullable = false)
    private String workoutName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_plan_id", unique = true, nullable = false)
    private UserWorkoutPlan userWorkoutPlan;

    @Column(name = "workout_desc", columnDefinition = "TEXT")
    private String workoutDescription; /* type text */

    @Column(name = "workout_technique")
    @Enumerated(EnumType.STRING)
    private WorkoutTechnique workoutTechnique;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
