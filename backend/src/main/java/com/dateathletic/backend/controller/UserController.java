package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.CheckForUserDto;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin (origins = "http://localhost:63342/")
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
