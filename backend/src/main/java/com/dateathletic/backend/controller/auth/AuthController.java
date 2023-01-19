package com.dateathletic.backend.controller.auth;

import com.dateathletic.backend.dto.LoginDto;
import com.dateathletic.backend.security.CustomUserDetailsService;
import com.dateathletic.backend.utils.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final Jwt jwt;

    @PostMapping(value = "/")
    public ResponseEntity<String> login(@RequestBody LoginDto dto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.username());
        if(userDetails != null){
            return ResponseEntity.ok(jwt.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("Some error has occured!");
    }
}
