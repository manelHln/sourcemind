package org.example;


import io.javalin.http.Handler;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ServerApplication serverInstance = ServerApplication.getInstance();
        Handler handler = new RequestHandler();
        serverInstance
                .app
                .post("/order", handler)
                .start(7070);
        RegistrationOrder[] registrationOrders = new RegistrationOrder[15];

        for(int i = 0; i < registrationOrders.length; i++){
            registrationOrders[i] = new RegistrationOrder();
            registrationOrders[i].start();
            registrationOrders[i].join();
        }
    }
}