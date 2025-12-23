import java.util.HashMap;
public class SubarrayHavingSumExactlyEqualToGivenNumber {
    /*
        Given an array arr[] of positive and negative integer, the objective is to find the
         subarray having sum equal to a given number k.
         examples:
         Input: arr[] = [10,2,-2,-20,10] , k = -10
         Output : 3
         Input: arr[] = [9,4,20,3,10,5] , k = 33
         Output: 2
         Input: arr[] = [1,3,5] , k = 2
         Output : 0
    */

    // 1️⃣ Brute Force Method
    public static int countSubarraysBruteForce(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 2️⃣ HashMap (Prefix Sum) Method
    public static int countSubarraysUsingHashMap(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle subarrays starting from index 0

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // 3️⃣ Sliding Window Method (ONLY works for POSITIVE numbers)
    public static int countSubarraysSlidingWindow(int[] arr, int k) {
        int start = 0, sum = 0, count = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > k && start <= end) {
                sum -= arr[start];
                start++;
            }

            if (sum == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {10, 2, -2, -20, 10};
        int k1 = -10;

        int[] arr2 = {9, 4, 20, 3, 10, 5};
        int k2 = 33;

        int[] arr3 = {1, 3, 5};
        int k3 = 2;

        System.out.println("Brute Force Output: " +
                countSubarraysBruteForce(arr1, k1));

        System.out.println("HashMap Output: " +
                countSubarraysUsingHashMap(arr1, k1));

        System.out.println("Sliding Window Output (Positive numbers only): " +
                countSubarraysSlidingWindow(arr2, k2));
    }
}
