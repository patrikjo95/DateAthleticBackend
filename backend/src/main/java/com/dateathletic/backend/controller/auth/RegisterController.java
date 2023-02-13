package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.dateathletic.backend.dto.SignUpDto.mapDtoToUser;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@CrossOrigin (origins = "http://localhost:63342/")
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/")
    public ResponseEntity<String> registerAccount(@Validated @RequestBody SignUpDto dto){
        if (service.existsByUsernameOrEmail(dto.username(), dto.email()))
            return new ResponseEntity<>("Username or email already exists", NOT_ACCEPTABLE);

        User user = new User();

       mapDtoToUser(dto, user, passwordEncoder);

        service.registerUser(user);
        return new ResponseEntity<>("User created, you may log in now", CREATED);
    }
}
