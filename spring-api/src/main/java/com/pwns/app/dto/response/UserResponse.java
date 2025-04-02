package com.pwns.app.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        Float weight,
        Float height
) { }
