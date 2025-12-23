public class ReverseOfLinkedlist {

    // Function to reverse the linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // Step 1: store next
            current.next = prev;      // Step 2: reverse link
            prev = current;           // Step 3: move prev
            current = next;           // Step 4: move current
        }
        return prev; // new head
    }

    // Function to traverse the linked list
    public static void iterate(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Original Linked List:");
        iterate(head);

        head = reverse(head);

        System.out.println("Reversed Linked List:");
        iterate(head);
    }
}
