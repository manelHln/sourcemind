package com.sourcemind.product.management.service;

import com.sourcemind.users.InMemoryUserDetailsManager;
import com.sourcemind.users.InMemoryUserDetailsManagerService;
import com.sourcemind.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final InMemoryUserDetailsManagerService inMemoryUserDetailsManagerService;

    public UserService(InMemoryUserDetailsManagerService inMemoryUserDetailsManagerService) {
        this.inMemoryUserDetailsManagerService = inMemoryUserDetailsManagerService;
    }

    public List<User> getUsers() {
        return inMemoryUserDetailsManagerService.getUsers();
    }
}
