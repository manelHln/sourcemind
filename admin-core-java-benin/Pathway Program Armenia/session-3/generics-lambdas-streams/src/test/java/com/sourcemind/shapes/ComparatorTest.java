package com.sourcemind.shapes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class ComparatorTest {

    // Test unit
    private final ShapeComparator comparator = new ShapeComparator();

    // Testing data
    private Shape shape1, shape2;
    private Rectangle rectangle1, rectangle2;
    private Circle circle1, circle2;

    @Before
    public void setup() {
        shape1 = new Shape();
        shape2 = new Shape();

        rectangle1 = new Rectangle(2, 5);
        rectangle2 = new Rectangle(3, 5);

        circle1 = new Circle(5);

        circle2 = new Circle(10);
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, comparator.compare(shape1, shape1));
    }

    @Test
    public void test2() {
        Assert.assertTrue(comparator.compare(circle1, rectangle1) > 0);
    }

    @Test
    public void inlineTest() {
        Comparator<Shape> inlineComparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return (int) (o1.calculateArea() - o2.calculateArea());
            }
        };

        Rectangle rectangle = new Rectangle(2, 5);

        Circle circle = new Circle(5);

        Assert.assertTrue(inlineComparator.compare(circle, rectangle) > 0);
    }

    @Test
    public void strictTest() {
        Comparator<Rectangle> rectangleComparator = new StrictShapeComparator<>();
        int compare = rectangleComparator.compare(rectangle1, rectangle2);
        Assert.assertTrue(compare < 0);

        // Compile error
//        rectangleComparator.compare(rectangle1, circle1);
    }
}
