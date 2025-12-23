import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 2, 6};
        int n = arr.length;

        // Insertion Sort
        for (int i = 1; i < n; i++) {

            int key = arr[i];   // element to be inserted
            int j = i - 1;

            // Shift elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
