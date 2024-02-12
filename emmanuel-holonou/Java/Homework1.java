import java.util.Scanner;

public class Homework1 {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        largeNumber();
        ceilValue();
        int[] numbers = {2, 65, 87, 3, 10};
        sortIntegers(numbers);
    }
    public static void largeNumber () {
        System.out.println("Enter your first number");
        int num_1 = userInput.nextInt();
        System.out.println("Enter your second number");
        int num_2 = userInput.nextInt();

        if(num_1 == num_2){
            System.out.println("Equal numbers");
            System.exit(1);
        }

        System.out.println("The largest number is " + Math.max(num_1, num_2));
    }

    public static void ceilValue() {
        System.out.println("Enter any float to get it's ceil value");
        double num = userInput.nextDouble();

        System.out.println("The rounded version of " + num + " is " + (int) Math.ceil(num));
    }

    public static void sortIntegers(int[] integers) {
        int[] sortedNumbers = new int[integers.length];
        int[] current = new int[integers.length];

        // Copy the input array to the 'current' array
        System.arraycopy(integers, 0, current, 0, integers.length);

        // Sort the 'current' array in descending order using a simple bubble sort algorithm
        for (int i = 0; i < current.length - 1; i++) {
            for (int j = 0; j < current.length - 1 - i; j++) {
                if (current[j] < current[j + 1]) {
                    // Swap elements if they are out of order
                    int temp = current[j];
                    current[j] = current[j + 1];
                    current[j + 1] = temp;
                }
            }
        }

        // Copy the sorted array back to the 'sortedNumbers' array
        System.arraycopy(current, 0, sortedNumbers, 0, current.length);

        System.out.println("Sorted numbers in descending order:");
        for (int num : sortedNumbers) {
            System.out.print(num + " ");
        }
    }

}
