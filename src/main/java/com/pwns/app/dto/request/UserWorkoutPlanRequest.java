package com.pwns.app.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pwns.app.utils.TrainingType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserWorkoutPlanRequest(
        Long userId,
        @NotNull int periodizationWeeks,
        String trainingType,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate periodStart
) { }
