package com.dateathletic.backend.dto;

import com.dateathletic.backend.domain.User;

import java.util.List;

public record UserDisplayDto(String username, String firstname, String lastname, String dob, String interests, String bio, List<String> imagePath, Long uid) {
    public static UserDisplayDto mapToUserDisplayDto(User user) {
        return new UserDisplayDto(
                user.getUsername(),
                user.getUserInfo().getFirstname(),
                user.getUserInfo().getLastname(),
                user.getUserInfo().getDoB(),
                user.getUserInfo().getInterests(),
                user.getUserInfo().getBio(),
                user.getProfileImg().getImagePaths(),
                user.getId());
    }
}

