package com.pwns.app.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(
        String name,
        String email,
        String password,
        String sex,
        Float weight,
        Float height,
        Float bodyFat,
        String trainingLevel
) { }
