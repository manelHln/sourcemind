import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextLine()) {
                var s = input.nextLine();
                System.out.println(isBalanced(s) ? "Yes" : "No");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    }

    public static boolean isBalanced(String s) {
        return true;
    }
}