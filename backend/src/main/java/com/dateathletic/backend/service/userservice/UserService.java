package com.dateathletic.backend.service.userservice;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.userservice.uc.UserServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceCrud {
    private final UserRepository userRepository;

    public boolean existsByUsernameAndEmail(String username, String email){
        return userRepository.existsByUsernameOrEmail(username, email);
    }
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void updateUserInfoById(Long id, UpdateUserDto dto) {

    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
