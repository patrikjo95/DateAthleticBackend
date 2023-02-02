package com.dateathletic.backend.dto;

import java.util.List;

public record CompletedSwipesDto(Long userId, List<CompletedSwipesData> data) {
}

