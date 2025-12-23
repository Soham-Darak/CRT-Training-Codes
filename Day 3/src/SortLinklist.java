class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SortLinklist {

    // Create Linked List from array
    public static Node createLinkList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Print Linked List
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Insertion Sort for Linked List
    public static Node insertionSortList(Node head) {
        Node dummy = new Node(0); // dummy sorted list

        Node current = head;
        while (current != null) {
            Node nextNode = current.next;

            Node prev = dummy;
            while (prev.next != null && prev.next.data < current.data) {
                prev = prev.next;
            }

            // Insert current node
            current.next = prev.next;
            prev.next = current;

            current = nextNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] testCase = {
                {},                 // Empty Set
                {1, 2, 3, 4, 5},     // Already Sorted
                {5, 4, 3, 2, 1},     // Reverse Sorted
                {4, 3, 1, 2},        // Random Order
                {3, 3, 1, 2},        // Duplicates
                {-1, 5, 3, 4, 0},    // Negative Values
                {2, 1}               // Two Elements
        };

        for (int i = 0; i < testCase.length; i++) {
            System.out.println("Test Case " + (i + 1));

            Node head = createLinkList(testCase[i]);

            System.out.print("Input : ");
            printList(head);

            head = insertionSortList(head);

            System.out.print("Output: ");
            printList(head);
            System.out.println("-----------------------");
        }
    }
}
