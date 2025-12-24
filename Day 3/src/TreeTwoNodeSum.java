import java.util.*;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int val){
        this.data = val;
    }
}

// Question no. 653 in Leet Code
public class TreeTwoNodeSum {

    // Main logic function
    public static boolean findTarget(TreeNode root, int target){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);   // Step 1: get inorder traversal

        int i = 0, j = list.size() - 1;

        // Step 2: Two-pointer technique
        while(i < j){
            int sum = list.get(i) + list.get(j);

            if(sum == target){
                return true;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }

    // Inorder traversal helper
    static void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int target = 7;
        System.out.println(findTarget(root, target));
    }
}
