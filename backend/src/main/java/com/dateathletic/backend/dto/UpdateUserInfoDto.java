package com.dateathletic.backend.dto;

import lombok.NonNull;

public record UpdateUserInfoDto(


        @NonNull
        String firstname,
        @NonNull
        String lastname,
       //@NonNull
       //String dob,
        @NonNull
        String bio,
        //@NonNull
        //String gender,
        @NonNull
        String interests,
        @NonNull
        String city

        //@NonNull
        //String genderPreferences



) {
}
