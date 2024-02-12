package com.sourcemind.shapes;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumerExample {
    public static void main(String[] args) {
        List<Shape> allShapes = new ArrayList<>();

        List<Rectangle> rectangles = List.of(new Rectangle(3, 4), new Rectangle(5, 3));
        List<Circle> circles = List.of(new Circle(3));

        copyList(allShapes, rectangles);
        copyList(allShapes, circles);

        System.out.println("All shapes = " + allShapes.size());

        // What about the following?
//        copyList(allShapes, allShapes);
    }

    public static void produce(List<? extends Rectangle> data) {
        Rectangle a = data.get(0);
        Shape b = data.get(1);

        // Not allowed
//        Square c = data.get(2); // not allowed
//
//        data.add(new Rectangle());	// not allowed
//        data.add(new Shape());	// not allowed
//        data.add(new Square());	// not allowed
    }

    public static void consume(List<? super Rectangle> data) {
        data.add(new Rectangle(2, 3));
        data.add(new Square(2));

        // Not allowed
//        data.add(new Shape()); // not allowed
//
//        Rectangle a = data.get(0);	// not allowed
    }

    public static <T> void copyList(List<? super T> destination, List<? extends T> source) {
        if (destination == null || source == null) {
            throw new IllegalArgumentException("lists cannot be null");
        }

        for (T item : source) {
            destination.add(item);
            System.out.println("Add to list");
        }
    }
}
