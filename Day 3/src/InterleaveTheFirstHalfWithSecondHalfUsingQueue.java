import java.util.*;
public class InterleaveTheFirstHalfWithSecondHalfUsingQueue {
    /*
        Given a Queue of even Numbers of elements,
        Interleave the first half with the second half.

        Input = [1,2,3,4,5]
        Output = [1,4,2,5,3,6]
    */

    public static void interleaveQueue(Queue<Integer> q) {

        // If queue size is odd, interleaving is not possible
        if (q.size() % 2 != 0) {
            System.out.println("Queue must have even number of elements");
            return;
        }

        int halfSize = q.size() / 2;

        // Auxiliary queue to store first half
        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Move first half elements into firstHalf queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave elements
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); // from first half
            q.add(q.remove());         // from second half
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        System.out.println("Before Interleaving: " + q);

        interleaveQueue(q);

        System.out.println("After Interleaving:  " + q);
    }
}
