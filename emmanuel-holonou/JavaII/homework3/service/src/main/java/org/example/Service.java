package org.example;

import static org.example.Core.countLines;
import static org.example.Core.countWords;

public class Service {
    public static void main(String[] args) {

        String filePath = "input-file.txt";

        try {
            int lines = countLines(filePath);
            int words = countWords(filePath);

            System.out.println("Number of lines: " + lines);
            System.out.println("Number of words: " + words);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
