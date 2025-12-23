public class JumpSearch {

    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;

        // Step size = √n
        int step = (int) Math.sqrt(n);
        int prev = 0;

        // Jump ahead in blocks
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.sqrt(n);

            // If we exceed array size
            if (prev >= n)
                return -1;
        }

        // Linear search in the identified block
        while (prev < Math.min(step, n)) {
            if (arr[prev] == key)
                return prev;
            prev++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {11, 31, 52, 74, 91, 113, 115, 123};
        int key = 74;

        int result = jumpSearch(arr, key);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
