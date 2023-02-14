package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.dto.CheckForUserDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/check")
@RequiredArgsConstructor
public class UtilController {
    private final UserService service;
    @PostMapping("/")
    public ResponseEntity<String> checkForUser(@RequestBody CheckForUserDto checkForUserDto) {
        String username = checkForUserDto.getUsername();
        String email = checkForUserDto.getEmail();

        if (service.existsByUsername(username)) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Det användarnamn du har angivit är upptaget");
        }
        else if (service.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Den email du har angivit är upptaget (testa att logga in)");
        }
        else {
            return ResponseEntity.ok("Det funkar");
        }

    }
}
