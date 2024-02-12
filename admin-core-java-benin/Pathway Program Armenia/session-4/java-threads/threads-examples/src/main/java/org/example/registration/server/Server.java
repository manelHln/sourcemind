package org.example.registration.server;

import io.javalin.Javalin;

import java.util.Map;

public class Server {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService(10);

        Javalin.create()
                .get("/register", context -> context.json(Map.of("result", service.register())))
                .get("/view", context -> context.json(Map.of("count", service.count())))
                .start(7070);
    }
}
