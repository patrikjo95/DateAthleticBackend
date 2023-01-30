package com.dateathletic.backend.controller;

import com.dateathletic.backend.dto.SwipeDataDto;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.swipeservice.SwipeService;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class testapi {

    private final SwipeService service;
    private final UserService service1;

    @GetMapping("/a")
    public boolean test1() {
        return service.canUserSwipe(1L, Instant.now().minus(Duration.ofHours(24)));
    }
    @GetMapping("/b")
    public int test2(Long uid){
        return service.swipesLeft(1L);
    }

    @GetMapping("/c")
    private SwipeDataDto mmnice(Long uid){
        List<UserDisplayDto>displayDto;
        int limit = service.swipesLeft(1L);
        displayDto = service.getSwipes(1L, min(limit, 10)).stream().map(UserDisplayDto::mapToUserDisplayDto).collect(toList());
        return new SwipeDataDto(
                displayDto,
                service.hasThisUserBeenSwipedOnByThese(1L, displayDto.stream().map(UserDisplayDto::uid).collect(toList())));
    }
}

