package com.dateathletic.backend.dto;

public record SwipeDto(Long userId, Long swipedUserId, boolean rightSwipe) {
}
