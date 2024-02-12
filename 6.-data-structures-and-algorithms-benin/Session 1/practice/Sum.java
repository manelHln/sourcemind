import java.util.Random;

public class Sum {
    public static int[] numbers = new Random().ints(100, 0, 16).toArray();

    public static void main(String[] args) {
        int sum = 0;
        for (int n: numbers) {
            sum += n;
        }
        System.out.println("Sum of numbers: " + sum);
    }
}
