package com.dateathletic.backend.service.swipeservice.uc;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.CompletedSwipesDto;
import com.dateathletic.backend.dto.SwipeDto;

import java.time.Instant;
import java.util.List;

public interface SwipeInterface {
    boolean canUserSwipe(Long id, Instant timeAgo);
    int countAmountOfSwipes(Long id);
    int swipesLeft(Long userid);
    List<User> getSwipes(Long id, Integer limit);
    List<SwipeDto>hasThisUserBeenSwipedOnByThese(Long userId, List<Long>userIds);
    void processSwipes(CompletedSwipesDto data);
}
