package com.dateathletic.backend;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;

@SpringBootApplication
public class BackendApplication {

	//ROLES
	public static final String USER_ROLE = "USER";
	public static final String ADMIN_ROLE = "ADMIN";

	//Api paths
	public static final String GUEST_API = "/welcome/to/";
	public static final String USER_API = "/user/";
	public static final String ADMIN_API = "/admin/";
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


}
