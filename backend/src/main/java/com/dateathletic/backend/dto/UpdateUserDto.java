package com.dateathletic.backend.dto;

public record UpdateUserDto(
        String firstname,
        String lastname,
        String doB,
        String bio,
        String gender,
        String interests,
        String city,
        String genderPreference) {
}
