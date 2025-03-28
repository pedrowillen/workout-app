package com.pwns.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkoutPlanNotFoundForUserException extends RuntimeException {
    public WorkoutPlanNotFoundForUserException(Long userId) {

        super("WorkoutPlan not found for user with id: " + userId)
      ;
    }
}
