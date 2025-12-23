

public class LinkListBasics {

    public static void iterate(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating linked list manually
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        // Traversing the linked list
        iterate(head);
    }
}
