package com.sourcemind.shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1.calculateArea() == o2.calculateArea()) {
            return 0;
        }
        return o1.calculateArea() > o2.calculateArea() ? 1 : -1;
    }
}
