package com.dateathletic.backend.controller;

import com.dateathletic.backend.service.matchservice.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class testapi {
    private final MatchService service;
}
