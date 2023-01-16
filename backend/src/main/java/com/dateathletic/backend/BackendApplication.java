package com.dateathletic.backend;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;

@SpringBootApplication
public class BackendApplication {

	public static final String USER_ROLE = "USER";
	public static final String ADMIN_ROLE = "ADMIN";
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}
