package com.pwns.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "exercise_sets")
@Builder
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    private WorkoutExercise exercise;

    @Column(name = "set_number", nullable = false)
    private Integer setNumberIndex;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "reps", nullable = false)
    private Integer reps;

    @Column(name = "reps_in_reserve", nullable = false)
    private Integer repsInReserve;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes; /* type text */

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
