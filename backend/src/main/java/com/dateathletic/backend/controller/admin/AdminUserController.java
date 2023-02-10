package com.dateathletic.backend.controller.admin;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.UserDisplayDto;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("admin/")
public class AdminUserController {
    private final UserService service;

    @PostMapping("/delete/user/{username}")
    public void delete(@PathVariable String username){
        User user = service.findUserByUsername(username).get();
        service.deleteUser(user);
    }

    @GetMapping("user/email/{email}")
    public UserDisplayDto findUserByEmail(@PathVariable String email){
        Optional<User> user = service.getUserByEmail(email);
        return UserDisplayDto.mapToDto(user.orElseThrow());
    }
}
