package com.sourcemind.product.management;

import com.sourcemind.product.management.service.UserService;
import com.sourcemind.users.InMemoryUserDetailsManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
