package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.repo.UserInfoServiceRepo;
import com.dateathletic.backend.repo.UserServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@CrossOrigin
@RequestMapping(path = "/register", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class RegisterController {
    private final UserServiceRepo userServiceRepo;
    private final UserInfoServiceRepo userInfoServiceRepo;


    @PostMapping("/")
    public ResponseEntity<String> registerAccount(@Validated @RequestBody SignUpDto dto) {
        if (userServiceRepo.existsByUsernameOrEmail(dto.username(), dto.email()))
            return new ResponseEntity<>("Username or email already exists", NOT_ACCEPTABLE);

        userServiceRepo.registerUser(dto);
        return new ResponseEntity<>("User created, you may log in now", HttpStatus.CREATED);
    }


   @PutMapping(value = "/updateUser{id}")
    public ResponseEntity<String> updateUser (@PathVariable Long id, @RequestBody UpdateUserDto dto) {

        userServiceRepo.updateUser(id, dto);

     return new ResponseEntity<>("Nu har du uppdaterat din profil", HttpStatus.OK);
    }

    @PutMapping(value = "/updateUserInfo{id}")
    public ResponseEntity<String> updateUserInfo (@PathVariable Long id, @RequestBody UpdateUserInfoDto dto) {

        userInfoServiceRepo.updateUserInfo(id, dto);

        return new ResponseEntity<>("Nu har du uppdaterat dina personuppgifter", HttpStatus.OK);
    }

}
