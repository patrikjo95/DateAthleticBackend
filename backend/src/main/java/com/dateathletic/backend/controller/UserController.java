package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @GetMapping("/username/{username}")
    public UserDisplayDto findUserByUsername(@PathVariable String username){
            User user = service.getUserByUsername(username).orElseThrow();
            return UserDisplayDto.mapToDto(user);
    }
}
