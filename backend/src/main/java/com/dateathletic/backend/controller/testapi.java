package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.Swipe;
import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SwipeDto;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.swipeservice.SwipeService;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class testapi {

    private final SwipeService service;
    private final UserService service1;

    @GetMapping("/a")
    public boolean test1(){
        return service.canUserSwipe(1L, Instant.now().minus(Duration.ofHours(24)));
    }

    @GetMapping("/b")
    public int test2(){
        return service.swipesLeft(1L);
    }

    @GetMapping("/c")
    private List<UserDisplayDto> mmnice(){
        List<UserDisplayDto>userDisplayList = new ArrayList<>(List.of());
        List<User> users = service.getSwipes(1L, 10);
        for (User u : users){
            List<SwipeDto> dtoList = u.getSwipes().stream()
                    .map(swipe -> new SwipeDto(swipe.getUser().getId(), swipe.getSwipedUserId(), swipe.isRightSwipe()))
                    .collect(toList());

            userDisplayList.add(new UserDisplayDto(
                    u.getUsername(),
                    u.getUserInfo().getFirstname(),
                    u.getUserInfo().getLastname(),
                    u.getUserInfo().getDoB(),
                    u.getUserInfo().getBio(),
                    u.getUserInfo().getInterests(),
                    u.getId(),
                    dtoList
            ));
        }
        return userDisplayList;
    }

    @GetMapping("/d")
    private List<SwipeDto>testmmsa(){
        return service.hasThisUserBeenSwipedOnByThese(1L, List.of(2L,3L,4L,5L));
    }
}
