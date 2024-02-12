package com.sourcemind.streams;

import java.io.File;
import java.util.Random;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        File file = new File(args[0]);
        String fileType = ".pdf";
        String[] listedFiles = file.list((dir, name) -> name.endsWith(fileType));
        if (listedFiles != null) {
            Stream.of(listedFiles)
                    .filter(s -> s.length() > 3)
                    .sorted((String s1, String s2) -> {
                        return s1.length() - s2.length();
                    })
                    .map((String name) -> name.substring(0, name.length() - 4))
                    .map((String name) -> {
                        int randomInc = new Random().nextInt(5);
                        return name.codePoints()
                                .map(charValue -> charValue + randomInc)
                                .collect(
                                        () -> new StringBuilder(),
                                        (StringBuilder stringBuilder, int codePoint) -> stringBuilder.appendCodePoint(codePoint),
                                        (StringBuilder a, StringBuilder b) -> a.append(b)
                                );
                    })
                    .map(stringBuilder -> stringBuilder.append(fileType))
                    .map(stringBuilder -> stringBuilder.toString())
                    .forEach(name -> {
                        System.out.println(name);
                    });
        }
    }
}
