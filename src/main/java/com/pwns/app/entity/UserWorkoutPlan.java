package com.pwns.app.entity;

import com.pwns.app.utils.TrainingType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users_workout_plans")
public class UserWorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @Column(name = "periodization_weeks", nullable = false)
    private int periodizationWeeks;

    @Column(name = "period_start")
    private LocalDate periodStart;

    @Column(name = "training_technique", length = 10)
    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    @Column(name = "period_end")
    private LocalDate periodEnd;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "userWorkoutPlan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Workout> workouts;

}
