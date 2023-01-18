package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.repo.UserServiceRepo;
import com.dateathletic.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Signature;
import java.util.Optional;

import static com.dateathletic.backend.BackendApplication.USER_ROLE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegisterController {
    private final UserServiceRepo serviceRepo;
    private final UserRepository userRepository;


    @PostMapping("register")
    public ResponseEntity<String> registerAccount(@Validated @RequestBody SignUpDto dto){
        if (serviceRepo.existsByUsernameOrEmail(dto.username(), dto.email()))
            return new ResponseEntity<>("Username or email already exists", NOT_ACCEPTABLE);

        serviceRepo.registerUser(dto);
       return new ResponseEntity<>("User created, you may log in now", HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateUser{id}")
    public ResponseEntity<String> updateUser (@PathVariable Long id, @RequestBody UpdateUserDto dto) {

        serviceRepo.updateUser(id, dto);

     return new ResponseEntity<>("Nu har du uppdaterat din profil", HttpStatus.OK);
    }

    @PutMapping(value = "/updateUserInfo{id}")
    public ResponseEntity<String> updateUserInfo (@PathVariable Long id, @RequestBody UpdateUserInfoDto dto) {

        serviceRepo.updateUserInfo(id, dto);

        return new ResponseEntity<>("Nu har du uppdaterat dina personuppgifter", HttpStatus.OK);
    }

}
