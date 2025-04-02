package com.pwns.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkoutPlanNotFoundException extends RuntimeException {
    public WorkoutPlanNotFoundException(Long id) {
        super(String.format("Workout plan with id %d not found.", id));

    }
}
