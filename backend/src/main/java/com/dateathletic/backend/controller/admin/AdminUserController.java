package com.dateathletic.backend.controller.admin;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dateathletic.backend.BackendApplication.ADMIN_API;

@RestController
@RequestMapping(ADMIN_API + "user/") //api/v1/admin/user/
public class AdminUserController {
    // TODO: 2023-01-20 remove user
    // TODO: 2023-01-20 ban user
    // TODO: 2023-01-20 hantera permissions
    // TODO: 2023-01-20 give users their daily swipes << will be challening and and important aspect to this application
}
