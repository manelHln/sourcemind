import java.util.Scanner;
import java.util.Stack;

public class Homework5 {
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

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

