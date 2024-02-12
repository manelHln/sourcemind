public class Homework2 {
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (y > 0) {
            return x + multiply(x, y - 1);
        } else {
            return -multiply(x, -y);
        }
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 3;
        int result = multiply(num1, num2);
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + result);
    }
}

