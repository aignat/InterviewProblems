package interviewproblems;

/**
 * Created by aignat on 21-Jun-16.
 */
public class Stack<T> {

    Node<T> top;

    Node pop() {

        if (top == null) {
            return null;
        }

        Node result = top;
        top = top.next;
        return result;
    }

    void push(T element) {

        Node<T> newNode = new Node(element);

        newNode.next = top;
        top = newNode;
    }

    public String toString() {
        String result = "";

        for (Node current = top; current != null; current = current.next) {
            result += current.value + " ";
        }

        return result;
    }
}
