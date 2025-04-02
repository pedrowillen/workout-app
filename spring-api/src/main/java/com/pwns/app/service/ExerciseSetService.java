package com.pwns.app.service;

import com.pwns.app.entity.ExerciseSet;
import com.pwns.app.repository.ExerciseSetRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {
    private final ExerciseSetRepository exerciseSetRepo;

    public ExerciseSet save (ExerciseSet exerciseSet) {
        return exerciseSetRepo.save(exerciseSet);
    }

    @Transactional
    public void deleteById(Long id) {
        ExerciseSet exerciseSet = exerciseSetRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exercise set not found."));

        exerciseSetRepo.delete(exerciseSet);
    }
}
