package com.sourcemind.users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDetailsManager {
    private final String passwordSuffix = "@M0402";

    @Value("${auth.username.prefix}")
    private String usernamePrefix;

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUsername(usernamePrefix + i);
            user.setPassword(user.getUsername() + passwordSuffix);
            user.setUserRole(UserRole.PRODUCT_OWNER);
            userList.add(user);
            System.out.printf("New added user - %s%n", user);
        }

        return userList;
    }
}
