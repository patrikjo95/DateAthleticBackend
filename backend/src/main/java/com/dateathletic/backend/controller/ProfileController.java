package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.security.AuthUser;
import com.dateathletic.backend.service.matchservice.MatchService;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
public class ProfileController {
    protected AuthUser loggedInUser = null;
    private final UserService userService;
    private final MatchService matchService;

    @GetMapping("/")
    public UserDisplayDto getProfile(){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserById(loggedInUser.getUserId()).orElseThrow();
        return UserDisplayDto.mapToDto(user);
    }

    @GetMapping("/mymatches")
    public void getMyFriends(@RequestParam("page") int page){
        matchService.findMyMatches(loggedInUser.getUserId(), PageRequest.of(page, 10));
    }
}
