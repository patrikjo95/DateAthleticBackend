package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dateathletic.backend.BackendApplication.USER_API;

@RestController
@RequestMapping(USER_API) //api/v1/user/
public class UserController {
    // TODO: 2023-01-20 get all friends
    // TODO: 2023-01-20 remove friends
    // TODO: 2023-01-20 block user
    // TODO: 2023-01-20 get specific user profile
    // TODO: 2023-01-20 search user by username
    // TODO: 2023-01-20 send contact request?!?!?!?

    // TODO: 2023-01-20 basic crud of user
}
