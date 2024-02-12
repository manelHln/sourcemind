package com.sourcemind.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryUserDetailsManagerService {
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public InMemoryUserDetailsManagerService(InMemoryUserDetailsManager inMemoryUserDetailsManager){
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    public List<User> getUsers(){
        return inMemoryUserDetailsManager.getUsers();
    }
}
