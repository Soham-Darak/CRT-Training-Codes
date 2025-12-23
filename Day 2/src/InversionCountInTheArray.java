public class InversionCountInTheArray {
    /*Given an Integer arr[] of Size n,Find the inverse count in the array. Two array elements arr[i] and arr[j]
    form inversion
    if arr[i] > arr[j] and i < j.
    Note: Inversion Count for a array indicate that how far (or close) the array is from being sorted.
    If the array is from being sorted.
    If the array is already sorted, then the inversion count is 0,
    the inversion count is maximum.
    Input: arr[] = {4,3,2,1}
    Output: 6
    Input arr[] = {1,2,3,4,5}
    Output: 0
    Input arr[] = {10,10,10}
    Output: 0
     */

    // Brute Force (unchanged)
    public static void BruteForce(int arr[]){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // Using Merge Sort
    static long divide(int arr[], int left, int mid, int right){

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        // copy data correctly
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        long count = 0;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }
            else{
                arr[k++] = rightArr[j++];
                count += (n1 - i);   // IMPORTANT LINE
            }
        }

        while(i < n1){
            arr[k++] = leftArr[i++];
        }

        while(j < n2){
            arr[k++] = rightArr[j++];
        }

        return count;
    }

    static long mergeSort(int arr[],int left,int right){
        long count = 0;

        if (left < right){
            int mid = (left + right) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += divide(arr, left, mid, right);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {4,3,2,1};

        BruteForce(arr);                 // Output: 6
        System.out.println(mergeSort(arr, 0, arr.length - 1)); // Output: 6
    }
}
