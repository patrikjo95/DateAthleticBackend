package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    //private final UserRepository repository;
    private final UserService service;

    private final UserRepository repository;

    @GetMapping("/username/{username}")
    public User findUserByUsername(@PathVariable String username){
            Optional<User> user = service.getUserByUsername(username);
            return user.orElse(null);
    }

    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email){
        Optional<User> user = service.getUserByEmail(email);
        return user.orElse(null);
    }


    @GetMapping("/username2/{username}")
    public Page<User> findAllByUsername(@PathVariable String username, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllByUsername(username, pageable);
    }

}
