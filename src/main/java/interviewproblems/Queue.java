package interviewproblems;

/**
 * Created by aignat on 23-Jun-16.
 */
public class Queue<T> {

    Node<T> first, last;

    public void enqueue(T item) {

        Node<T> newNode = new Node(item);

        if (first == null) {
            first = newNode;
            last = newNode;
        }
        last.next = newNode;
        last = last.next;
    }

    public Node<T> dequeue() {

        if (first == null) {
            return null;
        }

        Node<T> result = first;
        first = first.next;
        result.next = null;

        return result;
    }

    public String toString() {

        String result = "dequeue <-- | ";

        for (Node current = first; current != null; current = current.next) {
            result += current.value + " ";
        }

        result += "| <-- enqueue";

        return result;
    }
}
