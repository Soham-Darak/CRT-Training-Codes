import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3,11,21,5,1};
        int n = arr.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {

            // Last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
