package com.DSA;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        String[][] input = {
                {"hello", "bye"},
                {"this", "is"},
                {"a", "yo"},
                {"me", "you"}
        };

        String[][] sorted = sortBySumLengths(input);

        System.out.println(Arrays.deepToString(sorted));
    }
    public static String[][] sortBySumLengths(String[][] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(String[][] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(String[][] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[][] leftArray = new String[n1][];
        String[][] rightArray = new String[n2][];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            int sumLengthLeft = calculateSumLength(leftArray[i]);
            int sumLengthRight = calculateSumLength(rightArray[j]);

            if (sumLengthLeft <= sumLengthRight) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    private static int calculateSumLength(String[] arr) {
        int sum = 0;
        for (String str : arr) {
            sum += str.length();
        }
        return sum;
    }
}
