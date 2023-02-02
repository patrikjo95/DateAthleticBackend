package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.dateathletic.backend.BackendApplication.USER_API;
import static com.dateathletic.backend.BackendApplication.USER_ROLE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class RegisterController {
    private final UserService service;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerAccount(@Validated @RequestBody SignUpDto dto){
        if (service.existsByUsernameAndEmail(dto.username(), dto.email()))
            return new ResponseEntity<>("Username or email already exists", NOT_ACCEPTABLE);

        User user = new User();
        UserInfo userInfo = new UserInfo();

        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(USER_ROLE);

        userInfo.setFirstname(dto.firstname());
        userInfo.setLastname(dto.lastname());
        userInfo.setDoB(dto.doB());
        userInfo.setCity(dto.city());
        userInfo.setBio(dto.bio());
        userInfo.setInterests(dto.interests());
        userInfo.setGender(dto.gender());
        userInfo.setGenderPreference(dto.genderPreference());

        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        service.registerUser(user);
        return new ResponseEntity<>("User created, you may log in now", CREATED);
    }
}
