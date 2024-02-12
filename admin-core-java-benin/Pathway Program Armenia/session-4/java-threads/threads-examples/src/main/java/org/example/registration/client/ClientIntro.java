package org.example.registration.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientIntro {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://sourcemind.com/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status: " + response.statusCode());
            System.out.println(response.body());
            response.headers().map().forEach((k, v) -> {
                System.out.println(k + ": " + v);
            });

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
