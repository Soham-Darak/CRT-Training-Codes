public class MissingNumber {
    public static void main(String[] args) {

        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int n = arr.length + 1; // because one number is missing
        // Sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;
        // Sum of array elements
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        // Missing number
        int missingNumber = expectedSum - actualSum;

        System.out.println(missingNumber);
    }
}
