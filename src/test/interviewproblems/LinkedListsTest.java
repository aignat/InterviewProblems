package interviewproblems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aignat on 21-Jun-16.
 */
public class LinkedListsTest {
    @Test
    public void testAppend() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testDisplay() throws Exception {

    }

    @Test
    public void testRemoveDuplicates() throws Exception {
        Node linkedList = new Node<Integer>(1);
        LinkedLists.append(linkedList, 2);
        LinkedLists.append(linkedList, 3);
        LinkedLists.append(linkedList, 1);
        LinkedLists.append(linkedList, 2);
        LinkedLists.append(linkedList, 3);
        LinkedLists.append(linkedList, 1);
        LinkedLists.append(linkedList, 3);

        LinkedLists.removeDuplicates(linkedList);

        assertEquals(1, linkedList.value);
        assertEquals(2, linkedList.next.value);
        assertEquals(3, linkedList.next.next.value);
        assertEquals(null, linkedList.next.next.next);

    }

    @Test
    public void testNthToLastElement() throws Exception {
        Node linkedList = new Node<Integer>(1);
        LinkedLists.append(linkedList, 2);
        LinkedLists.append(linkedList, 3);
        LinkedLists.append(linkedList, 1);
        LinkedLists.append(linkedList, 2);
        LinkedLists.append(linkedList, 3);
        LinkedLists.append(linkedList, 1);
        LinkedLists.append(linkedList, 3);

        assertEquals(3, new LinkedLists().nthToLastElement(linkedList, 5).value);
    }

    @Test
    public void testDeleteMiddleNode() throws Exception {
//        Node linkedList = new Node<Integer>(1);
//        LinkedLists.append(linkedList, 2);
//        LinkedLists.append(linkedList, 3);
//
//        Node newLinkedList = new LinkedLists().
//        LinkedLists.Node linkedListToTest = linkedList.next.next.next;
//        ls.deleteMiddleNode(linkedListToTest);
    }

    @Test
    public void testAddLists() throws Exception {
        Node ls1 = new Node(3);
        LinkedLists.append(ls1, 1);
        LinkedLists.append(ls1, 5);

        Node ls2 = new Node(5);
        LinkedLists.append(ls2, 9);
        LinkedLists.append(ls2, 2);

        Node lsSum = LinkedLists.addLists(ls1, ls2);

        assertEquals(8, lsSum.value);
        assertEquals(0, lsSum.next.value);
        assertEquals(8, lsSum.next.next.value);
        assertEquals(null, lsSum.next.next.next);
    }

    @Test
    public void testLoopStart() throws Exception {
        Node linkedList = new Node<Integer>(1);
        Node node = new Node<Integer>(2);
        LinkedLists.append(linkedList, node);
        LinkedLists.append(linkedList, 3);
        LinkedLists.append(linkedList, 4);
        LinkedLists.append(linkedList, 5);
        LinkedLists.append(linkedList, 6);
        LinkedLists.append(linkedList, 7);
        LinkedLists.append(linkedList, node);

        assertEquals(2, LinkedLists.loopStart(linkedList).value);
    }

}