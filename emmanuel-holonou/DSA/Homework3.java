import java.util.Random;

public class NthElementFinder {

    public static int nth_element(int[] A, int n) {
        if (n < 0 || n >= A.length) {
            throw new IllegalArgumentException("Invalid value of n.");
        }

        return quickSelect(A, 0, A.length - 1, n);
    }

    private static int quickSelect(int[] A, int left, int right, int k) {
        if (left == right) {
            return A[left];
        }

        int pivotIndex = partition(A, left, right);

        if (k == pivotIndex) {
            return A[k];
        } else if (k < pivotIndex) {
            return quickSelect(A, left, pivotIndex - 1, k);
        } else {
            return quickSelect(A, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] A, int left, int right) {
        int pivotIndex = getPivotIndex(left, right);
        int pivotValue = A[pivotIndex];

        swap(A, pivotIndex, right);

        int i = left;

        for (int j = left; j < right; j++) {
            if (A[j] < pivotValue) {
                swap(A, i, j);
                i++;
            }
        }

        swap(A, i, right);
        return i;
    }

    private static int getPivotIndex(int left, int right) {
        Random rand = new Random();
        return rand.nextInt(right - left + 1) + left;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 7, 5, 2, 4, 6};
        int n = 2; 

        int result = nth_element(A, n);
        System.out.println("The " + n + "-th smallest element is: " + result);
    }
}

