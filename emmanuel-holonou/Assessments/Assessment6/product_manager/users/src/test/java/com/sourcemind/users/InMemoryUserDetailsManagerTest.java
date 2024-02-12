package com.sourcemind.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InMemoryUserDetailsManagerTest {

    @Autowired
    private InMemoryUserDetailsManager userDetailsManager;

    @Test
    public void testGetUsers() {
        List<User> users = userDetailsManager.getUsers();
        assertNotNull(users);
        assertEquals(10, users.size());

        for (int i = 1; i <= 10; i++) {
            User user = users.get(i - 1);
            String expectedUsername = "productUser" + i;
            String expectedPassword = expectedUsername + "@M0402";

            assertEquals(expectedUsername, user.getUsername());
            assertEquals(expectedPassword, user.getPassword());
        }
    }
}
