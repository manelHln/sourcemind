package service;

import core.countLines;
import core.countWords;
public class service {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify file name");
            return;
        }

        String filePath = args[0];

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