package com.sourcemind.shapes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

class Shape {

    protected double area;

    protected double calculateArea() {
        return area;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    protected double calculateArea() {
        return width * length;
    }
}

class Square extends Rectangle {
    private double side;

    public Square(double side) {
        super(side, side);
    }
}

public class Generics {

    // See: https://logging.apache.org/log4j/2.x/log4j-api/apidocs/index.html
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Map<String, Shape> collectionOfShapes = new HashMap<>(); // Try: LinkedHashMap, TreeMap

        Circle c1 = new Circle(2);
        collectionOfShapes.put("Small circle", c1);

        Circle c2 = new Circle(3);
        collectionOfShapes.put("Big circle", c2);

        collectionOfShapes.put("A shape", new Shape());

        new Generics().print(collectionOfShapes);
    }

    void print(Map<String, Shape> items) {
        Set<String> keys = items.keySet();
        for (String key : keys) {
            logger.info("Area of " + key + " is " + items.get(key).calculateArea());
        }
    }

    // Compile error
//    void print(Map<String, Circle> items) {
//
//    }
}
