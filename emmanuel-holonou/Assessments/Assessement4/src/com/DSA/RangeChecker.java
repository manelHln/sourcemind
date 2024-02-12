package com.DSA;

public class RangeChecker {
    public static void main(String[] args) {
        int[] array1 = {9, 7, 6, 4, 3, 1, -5};
        int result1 = inRange(array1, 4, 8);
        System.out.println("Result for array1: " + result1);

        int[] array2 = {9, 6, 1, -1, -2};
        int result2 = inRange(array2, 2, 5);
        System.out.println("Result for array2: " + result2);
    }
    public static int inRange(int[] array, int lo, int hi) {
        int firstInRangeIndex = binarySearchFirstInRange(array, lo, 0, array.length - 1);
        int lastInRangeIndex = binarySearchLastInRange(array, hi, 0, array.length - 1);

        if (firstInRangeIndex == -1 || lastInRangeIndex == -1) {
            return 0;
        }

        return lastInRangeIndex - firstInRangeIndex + 1;
    }

    private static int binarySearchFirstInRange(int[] array, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (array[mid] >= target) {
            return binarySearchFirstInRange(array, target, mid + 1, hi);
        } else {
            return binarySearchFirstInRange(array, target, lo, mid - 1);
        }
    }

    private static int binarySearchLastInRange(int[] array, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (array[mid] <= target) {
            return mid;
        } else {
            return binarySearchLastInRange(array, target, lo + 1, mid - 1);
        }
    }

}

