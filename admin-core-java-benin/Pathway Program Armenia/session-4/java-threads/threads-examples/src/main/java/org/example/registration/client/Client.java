package org.example.registration.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    // Number of users to send concurrent registration requests
    private static final int USERS = 23;

    // Server paths
    private static final URI REGISTER = URI.create("http://localhost:7070/register");
    private static final URI VIEW = URI.create("http://localhost:7070/view");

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(REGISTER)
                .build();

        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpClient sender = HttpClient.newHttpClient();

        Runnable doRequest = () -> {
            try {
                HttpResponse<String> response = sender.send(request, handler);
                String body = response.body();
                if (body.contains("true")) {
                    logger.info("Yes");
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread[] threads = new Thread[USERS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(doRequest);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        HttpClient viewer = HttpClient.newBuilder().build();
        HttpRequest viewRequest = HttpRequest.newBuilder(VIEW).build();
        HttpResponse<String> view = viewer.send(viewRequest, handler);
        System.out.println("Server value = " + view.body());
    }
}
