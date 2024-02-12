package org.example;

import org.example.myproxy.Image;
import org.example.myproxy.ProxyImage;

public class Main {
    public static void main(String[] args) {
        try {
            ProxyImage image = new ProxyImage("exa");
            image.display();
        } catch (Exception e) {
            System.out.println("Test 1: " + e.getMessage());
        }

        try {
            ProxyImage image = new ProxyImage("image.jpg");
            image.display();
        } catch (Exception e) {
            System.out.println("Test 2: " + e.getMessage());
        }
    }
}