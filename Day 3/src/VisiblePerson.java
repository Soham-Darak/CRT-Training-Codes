import java.util.Stack;
// LeetCode Question 1944
public class VisiblePerson {

    public static int[] personCount(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            // Pop all shorter people
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
                count++;
            }

            // If stack not empty, one taller person is visible
            if (!stack.isEmpty()) {
                count++;
            }

            result[i] = count;
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {10, 6, 8, 5, 11, 9};

        int[] result = personCount(height);

        // Print result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
