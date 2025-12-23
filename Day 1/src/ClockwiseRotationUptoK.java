import java.util.*;
public class ClockwiseRotationUptoK {
    // Input: arr[] = [8,7,1,3,12,15], k=2
    // Output: [12,15,8,7,1,3]
    // Given an array arr[] and an integer k, Rotate the array in place k times to the right(clockwise).
    // In each rotation, the last element moves to the front, and all other elements shift one position
    // to the right, Modify the array in place, do not return anything.
    public static void main(String[] args) {
        int arr[] = {8,7,1,3,12,15};
        int k = 2;
        int n = arr.length;
        // Reduce k if it is greater than array length
        k = k % n;

        // Rotate k times
        for (int r = 0; r < k; r++) {

            // Step 1: store last element
            int last = arr[n - 1];

            // Step 2: shift elements to the right
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }

            // Step 3: move last element to front
            arr[0] = last;
        }

        System.out.println(Arrays.toString(arr));
    }
}

