package com.dateathletic.backend.dto;

import lombok.NonNull;

public record UpdateUserDto(

        @NonNull
        String username,
        @NonNull
        String email,
        @NonNull
        String password



) {
}
