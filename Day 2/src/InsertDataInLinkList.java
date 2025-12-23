class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class InsertDataInLinkList {
     static void InsertAtTail(Node n1 , Node head){
        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = n1;
    }

    public static Node InsertAtHead(Node n1, Node head){
         n1.next = head;
         return n1;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        Node n1 = new Node(40);

        // InsertAtTail(n1 ,head);
        //Node temp = head;
        InsertAtHead(n1,head);
        Node temp = n1;
        while(temp != null){

            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

}
