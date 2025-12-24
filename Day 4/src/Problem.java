import java.util.*;
public class Problem {
    /*
        You're given an array A of n integers and q queries.
        Each queries can be one of the following two types:
        Type 1 Query: (1, l, r) - Replace A[i] with (i-l+1)*A[l] for each index, where l <= i <= r.
        Type 2 Query: (2, l, r) - Calculate the sum of the elements in A from index l to index r.

        Find the sum of answers for all type 2 queries. Since answer can be large, return it modulo 109 + 7.

    static final long MOD = 1000000007;

    // Function to process queries
    public static long query(int[] A, int n, int q, Scanner sc) {
        long totalSum = 0;

        for (int qi = 0; qi < q; qi++) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Convert to 0-based index
            l--;
            r--;

            if (type == 1) {
                int baseValue = A[l];
                for (int i = l; i <= r; i++) {
                    A[i] = (int) ((long)(i - l + 1) * baseValue % MOD);
                }
            }
            else if (type == 2) {
                long sum = 0;
                for (int i = l; i <= r; i++) {
                    sum = (sum + A[i]) % MOD;
                }
                totalSum = (totalSum + sum) % MOD;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] A = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Number of queries
        int q = sc.nextInt();

        // Process queries
        long result = query(A, n, q, sc);

        // Output final answer
        System.out.println(result);
    }

     */

    // Test Case 1
    // Size of the Array = 7
    // A[] = {1,4,5,1,6,7,8}
    // Total number if Queries = 5
//        Query 1 = 116
//        Query 2 = 115
//        Query 3 = 255
//        Query 4 = 234
//        Query 5 = 233
//     Answer : 60
    // Test Case 2
    // Size of the Array = 7
    // A[] = {3,7,4,2,5,3,7}
    // Total number if Queries = 5
//        Query 1 = 104
//        Query 2 = 201
//        Query 3 = 136
//        Query 4 = 233
//        Query 5 = 205
    // Answer: 111
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Size of the Array: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Enter the elements of the Array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + " Element: ");
            A[i] = sc.nextInt();   // ✅ FIXED
        }

        int totalSum = 0;

        System.out.println("Enter the Total Queries");
        int q = sc.nextInt();

        for (int k = 0; k < q; k++) {
            System.out.print("\nEnter the Type of " + (k + 1) + " Query: ");
            int type = sc.nextInt();

            System.out.println("Enter the Starting index of the Array: ");
            int L = sc.nextInt();

            System.out.println("Enter the Ending index of the Array: ");
            int r = sc.nextInt();

            // ✅ Convert to 0-based indexing
            L--;
            r--;

            if (type == 1) {
                // Replace the Array from L to r
                for (int i = L; i <= r; i++) {
                    A[i] = (i - L + 1) * A[L];
                }
            }
            else if (type == 2) {
                // Total sum of the Array from L to r
                int sum = 0;
                for (int i = L; i <= r; i++) {
                    sum = sum + A[i];
                }
                totalSum = totalSum + sum;
            }
        }

        System.out.println("\nTotal Sum of all type 2 Queries: " + totalSum);
    }

}

