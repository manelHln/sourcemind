package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CoreNew {


    public static long countLines(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.count();
        }
    }

    public static long countWords(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .count();
        }
    }
}