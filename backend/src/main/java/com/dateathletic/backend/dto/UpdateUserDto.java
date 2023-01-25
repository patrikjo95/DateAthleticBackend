package com.dateathletic.backend.dto;

public record UpdateUserDto(
        String firstname,
        String lastname,
        String DoB,
        String height,
        String bio,
        String gender,
        String interests,
        String city,
        String genderPreference) {
}
