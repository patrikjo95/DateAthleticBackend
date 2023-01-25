package com.dateathletic.backend.controller.auth;


import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.service.UserService;
import com.dateathletic.backend.service.UserServiceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dateathletic.backend.BackendApplication.USER_API;

@RestController
@RequestMapping( path = USER_API + "/update", produces = "application/json;")
@RequiredArgsConstructor
public class UpdateController {

    private final UserServiceInfo userServiceInfo;
    private final UserService userService;



    @PutMapping(value = "/User{id}")
    public ResponseEntity<String> updateUser (@PathVariable Long id, @RequestBody UpdateUserDto dto) {

        userService.updateUser(id, dto);

        return new ResponseEntity<>("Nu har du uppdaterat din profil", HttpStatus.OK);
    }

    @PutMapping(value = "/UserInfo{id}")
    public ResponseEntity<String> updateUserInfo (@PathVariable Long id, @RequestBody UpdateUserInfoDto dto) {

        userServiceInfo.updateUserInfo(id, dto);

        return new ResponseEntity<>("Nu har du uppdaterat dina personuppgifter", HttpStatus.OK);
    }
}
