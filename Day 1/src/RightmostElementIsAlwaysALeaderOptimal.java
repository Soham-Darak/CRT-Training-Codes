import java.util.*;

public class RightmostElementIsAlwaysALeaderOptimal {

    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};
        int n = arr.length;

        // The rightmost element is always a leader
        int maxFromRight = arr[n - 1];
        System.out.print("Leaders: " + maxFromRight + " ");

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
    }
}
