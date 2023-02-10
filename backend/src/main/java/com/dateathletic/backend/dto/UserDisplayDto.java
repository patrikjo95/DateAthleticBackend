package com.dateathletic.backend.dto;

import com.dateathletic.backend.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

public record UserDisplayDto(
        String username,
        String firstname,
        String lastname,
        String email,
        String bio,
        String city,
        String doB,
        String interests,
        String preference,
        List<String> imagePath,
        Long uid) {

    public static UserDisplayDto mapToDto(User user){
        return new UserDisplayDto(
                user.getUsername(),
                user.getUserInfo().getFirstname(),
                user.getUserInfo().getLastname(),
                user.getEmail(),
                user.getUserInfo().getBio(),
                user.getUserInfo().getCity(),
                user.getUserInfo().getDoB(),
                user.getUserInfo().getInterests(),
                user.getUserInfo().getGenderPreference(),
                user.getProfileImg().getImagePaths(),
                user.getId()
        );
    }

}

