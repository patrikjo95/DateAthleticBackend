package com.dateathletic.backend.dto;

import org.springframework.lang.NonNull;
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
        @Nullable
        String dob,
        @NonNull
        String city,
        @Nullable
        String bio,
      @Nullable
        String interests,
      @Nullable
        String gender,

        @Nullable
        String genderPrefrences
)
{}
