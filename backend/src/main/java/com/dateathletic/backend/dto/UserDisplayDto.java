package com.dateathletic.backend.dto;

import com.dateathletic.backend.domain.User;

public record UserDisplayDto(String username, String firstname, String lastname, String dob, String bio, String preferences, Long uid) {
    public static UserDisplayDto mapToUserDisplayDto(User user) {
        return new UserDisplayDto(
                user.getUsername(),
                user.getUserInfo().getFirstname(),
                user.getUserInfo().getLastname(),
                user.getUserInfo().getDoB(),
                user.getUserInfo().getBio(),
                user.getUserInfo().getInterests(),
                user.getId());
    }
}

