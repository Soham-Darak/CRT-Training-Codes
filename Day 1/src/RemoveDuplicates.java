import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        ArrayList list1 = new ArrayList<Integer>();

        ArrayList list2 = new ArrayList();
        list2.add(1);
        list2.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(2);

        Set set = new HashSet(list2);
        /* Set Dos'nt allow dulplicates and List Does*/
        System.out.println(list2);
        System.out.println(set);
    }
}
