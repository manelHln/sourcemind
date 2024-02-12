package com.sourcemind.shapes;

import java.util.Comparator;

public class AnonymousTest {
    public static void main(String[] args) {
        Comparator<Shape> myComparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.calculateArea() - o2.calculateArea());
            }
        };

//        myComparator.compare(/* two shapes */);

        // TODO define a reverse comparator
    }
}