import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket
            else {
                // If stack is empty, no opening bracket to match
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pairs
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}"
        };

        for (String s : testCases) {
            System.out.println("Input: " + s + " → Output: " + isValid(s));
        }
    }
}
