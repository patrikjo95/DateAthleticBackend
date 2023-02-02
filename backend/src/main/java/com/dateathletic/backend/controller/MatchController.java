package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.Match;
import com.dateathletic.backend.security.AuthUser;
import com.dateathletic.backend.service.matchservice.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/match")
@RequiredArgsConstructor
public class MatchController {

    protected AuthUser loggedInUser = null;
    private final MatchService service;

    @PostMapping("/removeMatch/{targetId}")
    public void deleteMatch(@PathVariable("targetId") Long targetId){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        service.deleteMatch(service.getMatches(loggedInUser.getUserId(), targetId));
    }

    @GetMapping("/myMatches/{page}")
    public Page<Match> findUsersMatches(@PathVariable("page") int page){
        loggedInUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.findMyMatches(loggedInUser.getUserId(), PageRequest.of(page, 10));
    }
}
