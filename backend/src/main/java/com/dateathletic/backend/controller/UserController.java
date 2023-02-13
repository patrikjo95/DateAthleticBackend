package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.CheckForUserDto;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/username/email")
    public ResponseEntity<String> findUserByUsernameAndEmail(@RequestBody CheckForUserDto userDto) {
        if (service.existsByUsername(userDto.username()))
            return new ResponseEntity<>("Username already exists", HttpStatus.NOT_ACCEPTABLE);

        if (service.existsByEmail(userDto.email()))
            return new ResponseEntity<>("Email already exists", HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
