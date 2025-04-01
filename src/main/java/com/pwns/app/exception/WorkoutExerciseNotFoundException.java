package com.pwns.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkoutExerciseNotFoundException extends RuntimeException {
    public WorkoutExerciseNotFoundException(Long userId) {
        super("WorkoutExercise not found with id: " + userId)
      ;
    }
}
