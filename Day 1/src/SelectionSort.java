import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {3,11,21,5,1};
        int n = arr.length;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {

            // Assume the minimum element is at index i
            int min = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap the found minimum element with first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
