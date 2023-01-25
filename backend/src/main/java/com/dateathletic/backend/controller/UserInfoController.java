package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/knas")
public class UserInfoController {
    private final UserInfoRepository repository;

    Pageable sortedByName =
            PageRequest.of(0, 6, Sort.by("firstname"));
}
