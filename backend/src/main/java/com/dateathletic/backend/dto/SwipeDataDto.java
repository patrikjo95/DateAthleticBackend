package com.dateathletic.backend.dto;

import com.dateathletic.backend.dto.SwipeDto;
import com.dateathletic.backend.dto.UserDisplayDto;

import java.util.List;

public record SwipeDataDto(List<UserDisplayDto> userDisplayDtoList, List<SwipeDto> swipeDtoList) {
}
