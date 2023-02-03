package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.service.UserServiceInfo;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static com.dateathletic.backend.BackendApplication.USER_API;
import static com.dateathletic.backend.BackendApplication.USER_ROLE;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping( path = USER_API + "/register")
@RequiredArgsConstructor
public class RegisterController {




    private final UserService userService;




    @PostMapping("/")
    public ResponseEntity<String> registerAccount(@Validated @RequestBody SignUpDto dto) {
        if (userService.existsByUsernameOrEmail(dto.username(), dto.email()))
            return new ResponseEntity<>("Username or email already exists", NOT_ACCEPTABLE);


       userService.registerUser(dto);
        return new ResponseEntity<>("User created, you may log in now", CREATED);
    }

}
