import java.util.PriorityQueue;

public class KthSmallestElement {

    // ---------- METHOD 1: Using Priority Queue ----------
    public static void usingPriorityQueue(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        System.out.println("Kth Smallest (PriorityQueue): " + pq.peek());
    }

    // ---------- METHOD 2: Using QuickSelect/QuickSort (Best Time Complexity) ----------
    public static int quickSelect(int[] arr, int low, int high, int k) {

        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            if (pivotIndex == k - 1)
                return arr[pivotIndex];
            else if (pivotIndex > k - 1)
                return quickSelect(arr, low, pivotIndex - 1, k);
            else
                return quickSelect(arr, pivotIndex + 1, high, k);
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        // Call Priority Queue method
        usingPriorityQueue(arr, k);

        // Call QuickSelect method
        int result = quickSelect(arr, 0, arr.length - 1, k);
        System.out.println("Kth Smallest (QuickSelect): " + result);
    }
}
