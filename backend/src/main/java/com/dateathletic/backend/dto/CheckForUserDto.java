package com.dateathletic.backend.dto;

import org.springframework.lang.NonNull;

public record CheckForUserDto(

        @NonNull
        String username,
        @NonNull
        String email


) {
}
