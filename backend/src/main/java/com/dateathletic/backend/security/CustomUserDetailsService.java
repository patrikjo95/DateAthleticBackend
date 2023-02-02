package com.dateathletic.backend.security;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> data = userService.findUserByUsername(username);
        if (data.isEmpty()) throw new UsernameNotFoundException("Username not found");
        return new AuthUser(
            data.get(), data.get().getId()
        );
    }
}
