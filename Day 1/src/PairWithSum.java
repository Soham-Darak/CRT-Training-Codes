import  java.util.*;
public class PairWithSum {
    public static void main(String[] args) {
//        int[] arr = {2,7,11,15};
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i);
//        }
//        System.out.println(Arrays.toString(arr));

        List<Integer> arrList = new ArrayList();
        arrList.add(2);
        arrList.add(7);
        arrList.add(11);
        arrList.add(15);
        int target = 9;
        int n = arrList.toArray().length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrList.get(i) + arrList.get(j) == target) {
                    System.out.println("Pair found: (" + arrList.get(i) + ", " + arrList.get(j) + ")");
                }
            }

        }
    }
}
