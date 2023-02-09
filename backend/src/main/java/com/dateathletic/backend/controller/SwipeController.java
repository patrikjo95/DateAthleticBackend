package com.dateathletic.backend.controller;

import com.dateathletic.backend.dto.CompletedSwipesDto;
import com.dateathletic.backend.dto.SwipeDataDto;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.security.AuthUser;
import com.dateathletic.backend.service.swipeservice.SwipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Math.min;
import static java.time.Duration.ofHours;
import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/user/swipe")
@RequiredArgsConstructor
public class SwipeController {
    protected AuthUser loggedInUser = null;
    private final SwipeService service;
    @GetMapping("/canSwipe")
    public Boolean canUserSwipe(){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.canUserSwipe(
                loggedInUser.getUserId(),
                now().minus(ofHours(24))
        );
    }
    @GetMapping("/swipesLeft")
    public Integer swipesLeft(){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.swipesLeft(loggedInUser.getUserId());
    }
    @GetMapping("/getSwipes")
    public SwipeDataDto getSwipes(){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserDisplayDto> displayDto;
        int limit = service.swipesLeft(
                loggedInUser.getUserId());
        displayDto = service.getSwipes(
                loggedInUser.getUserId(), min(limit, 10)).stream()
                .map(UserDisplayDto::mapToDto).collect(toList());
        return new SwipeDataDto(
                displayDto,
                service.hasThisUserBeenSwipedOnByThese(
                        loggedInUser.getUserId(),
                        displayDto.stream().map(UserDisplayDto::uid)
                                .collect(toList())));
    }

    @GetMapping("/processCompletedSwipes")
    public void processCompletedSwipes(@RequestBody CompletedSwipesDto dataDto){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (dataDto == null) throw new RuntimeException("");
        service.processSwipes(dataDto);
    }
}
