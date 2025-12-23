import java.util.*;
public class RightmostElementIsAlwaysALeader {
    // Input: arr[] = {16,17,4,3,5,2}
    // Output: [17 5 2]

    // Input: arr[] = {1,2,3,4,5,2}
    // Output: [5 2]
    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        int n = arr.length;
        System.out.println(arr[n-1]);
        for (int i = 0; i < n; i++) {
            if(arr[i]<arr[i+1]){
                System.out.println(arr[i+1]);
            }
        }
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(2);

        int a = arrList.toArray().length;

        for (int j = 0; j < a; j++) {
            if (arrList.get(j) > arrList.get(j+1)){
                System.out.println(arrList.get(j+1));
            }
        }
    }
}
