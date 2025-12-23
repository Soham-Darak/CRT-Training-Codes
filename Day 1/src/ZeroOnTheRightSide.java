import java.util.*;
public class ZeroOnTheRightSide {
    //Input: [0,1,0,3,12]
    //Output: [1,3,12,0,0]

    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));

        // Using Array List
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(0);
        arrList.add(1);
        arrList.add(0);
        arrList.add(3);
        arrList.add(12);

        int a = 0;

        for (int b = 0; b < arrList.size(); b++) {
            if (arrList.get(b) != 0) {
                int temp = arrList.get(b);
                arrList.set(b, arrList.get(a));
                arrList.set(a, temp);
                a++;
            }
        }
        System.out.println(arrList);
    }
}
