package org.example;


import io.javalin.http.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ServerApplication serverInstance = ServerApplication.getInstance();
        RequestHandler handler = new RequestHandler();
        serverInstance
                .app
                .post("/order", handler)
                .get("/test", handler)
                .start(7070);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        RegistrationOrder[] registrationOrders = new RegistrationOrder[15];

        for(int i = 0; i < registrationOrders.length; i++){
            registrationOrders[i] = new RegistrationOrder();
            executor.submit(registrationOrders[i]);
        }
//        Thread guard = new Thread(()->{
//            while (!RequestHandler.finished){
//                try {
//                    RequestHandler.lock.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
////      interrupt main thread here to stop the server
////            System.out.println(111);
//        serverInstance.app.stop();
//        });
//        guard.start();
    }
}