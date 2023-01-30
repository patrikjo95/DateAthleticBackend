package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/knas")
public class UserInfoController {
    private final UserInfoRepository repository;

    private final UserInfoService service;

    @GetMapping
    public Page<UserInfo> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }

    @GetMapping("/firstname/{firstname}")
    public UserInfo findUserByfirstName(@PathVariable String firstname){
        Optional<UserInfo> user = service.getUserByFirstname(firstname);
        return user.orElse(null);
    }

    @GetMapping("/lastname/{lastname}")
    public UserInfo findUserBylastName(@PathVariable String lastname){
        Optional<UserInfo> user = service.getUserByLastname(lastname);
        return user.orElse(null);
    }
}
