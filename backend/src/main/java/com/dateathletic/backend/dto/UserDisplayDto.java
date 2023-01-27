package com.dateathletic.backend.dto;

import java.util.List;

public record UserDisplayDto(String username, String firstname, String lastname, String dob, String bio, String preferences, Long uid, List<SwipeDto> swipeDtoList) {
}

