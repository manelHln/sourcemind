package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RegistrationOrder extends Thread{

    @Override
    public void run(){
            try{
                HttpClient client = HttpClient.newBuilder()
                        .connectTimeout(Duration.ofSeconds(10))
                        .build();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:7070/order"))
                        .header("Content-Type", "text/plain")
                        .POST(HttpRequest.BodyPublishers.ofString("Simple request"))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.statusCode());
                System.out.println(response.body());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
}
