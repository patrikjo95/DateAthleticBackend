package com.dateathletic.backend.controller.auth;



import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path ="/update", produces = "application/json;")
@RequiredArgsConstructor
public class UpdateController {



    private final UserService userService;


    @PutMapping(value = "/UserInfo{id}")
    public ResponseEntity<String> updateUserInfo (@PathVariable Long id, @RequestBody UpdateUserDto dto) {

        userService.updateUserInfoById(id, dto);

        return new ResponseEntity<>("Nu har du uppdaterat dina personuppgifter", HttpStatus.OK);
    }
}
