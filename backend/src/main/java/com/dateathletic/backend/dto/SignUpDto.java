package com.dateathletic.backend.dto;

import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;

public record SignUpDto(
        @NonNull
        String username,
        @NonNull
        String email,
        @NonNull
        String password,
        @NonNull
        String firstname,
        @NonNull
        String lastname,
        @NonNull
        String doB,
        @NonNull
        String city,
        @Nullable
        String bio,
        @NonNull
        String interests,
        @NonNull
        String gender,
        @NonNull
        String genderPreference
) {
}
