/*
    Given a binary tree and a target tree node,
    the tree starts burning from the target.
    Every 1 second, the fire spreads to adjacent nodes (parent + children)
    Goal : Find the maximum time to burn the entire tree

             1
            /  \
           2    3
          / \    \
         4   5    6

     Target: 5
*/
public class LargestSubTree {
    static int maxTime = 0;

    public static int burnTree(Node root, int target) {
        findTarget(root, target);
        return maxTime;
    }

    // Returns distance of current node from target
    private static int findTarget(Node root, int target) {
        if (root == null) return -1;

        if (root.data == target) {
            height(root, 0);
            return 1;
        }

        int leftDist = findTarget(root.left, target);
        if (leftDist != -1) {
            height(root.right, leftDist + 1);
            maxTime = Math.max(maxTime, leftDist);
            return leftDist + 1;
        }

        int rightDist = findTarget(root.right, target);
        if (rightDist != -1) {
            height(root.left, rightDist + 1);
            maxTime = Math.max(maxTime, rightDist);
            return rightDist + 1;
        }

        return -1;
    }

    // Calculates height while updating burn time
    private static void height(Node root, int time) {
        if (root == null) return;

        maxTime = Math.max(maxTime, time);
        height(root.left, time + 1);
        height(root.right, time + 1);
    }

    public static void main(String[] args) {

        /*
                 1
                /  \
               2    3
              / \    \
             4   5    6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int target = 5;
        System.out.println("Time to burn tree: " + burnTree(root, target));
    }
}
