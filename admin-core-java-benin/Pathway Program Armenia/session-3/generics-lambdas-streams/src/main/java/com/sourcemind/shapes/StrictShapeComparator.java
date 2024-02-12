package com.sourcemind.shapes;

import java.util.Comparator;

public class StrictShapeComparator<T extends Shape> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return (int) (o1.calculateArea() - o2.calculateArea());
    }
}
