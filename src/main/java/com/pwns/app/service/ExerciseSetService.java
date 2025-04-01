package com.pwns.app.service;

import com.pwns.app.entity.ExerciseSet;
import com.pwns.app.repository.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {
    private final ExerciseSetRepository exerciseSetRepo;

    public ExerciseSet save (ExerciseSet exerciseSet) {
        return exerciseSetRepo.save(exerciseSet);
    }
}
