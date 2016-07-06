package interviewproblems;

public class LinkedLists {

    /**
     * Add a value at the end of the list
     */
    public static void append(Node head, Object newValue) {
        Node newNode = new Node(newValue);

        append(head, newNode);
    }

    public static void append(Node current, Node newNode) {
        if (current == null) {
            current.value = newNode.value;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Delete an element with a given value
     */
    public static Node delete(Node head, Object valueToDelete) {
        Node currentNode;
        Node nextNode;

        if (head == null) {
            return null;
        }

        //go to first valid element
        while (head.value == valueToDelete) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }

        currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.value == valueToDelete) {
                nextNode = currentNode.next;
                while (nextNode != null && nextNode.value == valueToDelete) {
                    nextNode = nextNode.next;
                }
                currentNode.next = nextNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    /**
     * 2.1 Write code to remove duplicates from an unsorted linked list. FOLLOW
     * UP How would you solve this problem if a temporary buffer is not allowed?
     */
    public static void removeDuplicates(Node head) {
        Node currentNode = head;

        //a list with 0 or 1 elements has no duplicates
        if (head == null || head.next == null) {
            return;
        }

        while (currentNode != null && currentNode.next != null) {
            Node nextNode = currentNode;
            while (nextNode != null && nextNode.next != null) {
                if (currentNode.value == nextNode.next.value) {
                    nextNode.next = nextNode.next.next;
                } else {
                    nextNode = nextNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * 2.2 Implement an algorithm to find the nth to last element of a singly
     * linked list.
     */
    public Node nthToLastElement(Node head, int nth) {
        Node milestoneNode1 = head;
        Node milestoneNode2 = head;
        int counter = 0;

        //set milestoneNode2 on the nth element
        while (counter < nth && milestoneNode2 != null) {
            counter++;
            milestoneNode2 = milestoneNode2.next;
        }

        //if there are less than nth elements in the list return null
        if (counter < nth) {
            return null;
        }

        //iterate trough the list, milestoneNode 2 will be tha last element,
        //milestoneNode1 will be nth elements to last element
        while (milestoneNode2.next != null) {
            milestoneNode1 = milestoneNode1.next;
            milestoneNode2 = milestoneNode2.next;
        }

        return milestoneNode1;
    }

    /**
     * 2.3 Implement an algorithm to delete a node in the middle of a single
     * linked list, given only access to that node. EXAMPLE Input: the node ‘c’
     * from the linked list a->b->c->d->e Result: nothing is returned, but the
     * new linked list looks like a->b->d->e
     */
    public void deleteMiddleNode(Node node) {
        if (node == null) {
            return;
        }
        Node aux = node.next.next;
        node.value = node.next.value;
        node.next = aux;
    }

    /**
     * 2.4 You have two numbers represented by a linked list, where each node
     * contains a single digit. The digits are stored in reverse order, such
     * that the 1’s digit is at the head of the list. Write a function that adds
     * the two numbers and returns the sum as a linked list. EXAMPLE Input: (3
     * -> 1 -> 5) + (5 -> 9 -> 2) Output: 8 -> 0 -> 8
     */
    public static Node addLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> sumList = new Node<Integer>(0);
        boolean carry = false;
        int sum = 0;

        while (list1 != null && list2 != null) {
            sum = list1.value + list2.value;
            if (carry) {
                sum++;
            }
            if (sum > 9) {
                sum = sum % 10;
                carry = true;
            } else {
                carry = false;
            }
            append(sumList, sum);
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 != null) {
            while (list1 != null) {
                sum = list1.value;
                if (carry) {
                    sum++;
                }
                if (sum > 9) {
                    sum = sum % 10;
                    carry = true;
                } else {
                    carry = false;
                }
                append(sumList, sum);
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            while (list2 != null) {
                sum = list2.value;
                if (carry) {
                    sum++;
                }
                if (sum > 9) {
                    sum = sum % 10;
                    carry = true;
                } else {
                    carry = false;
                }
                append(sumList, sum);
                list2 = list2.next;
            }
        }

        if (carry) {
            append(sumList, 1);
        }

        return sumList.next;
    }

    /**
     * 2.5 Given a circular linked list, implement an algorithm which returns
     * node at the beginning of the loop. DEFINITION Circular linked list: A
     * (corrupt) linked list in which a node’s next pointer points to an earlier
     * node, so as to make a loop in the linked list. EXAMPLE input: A -> B -> C
     * -> D -> E -> C [the same C as earlier] output: C
     */
    public static Node loopStart(Node head) {
        Node currentNode1 = head.next;
        Node currentNode2 = head.next.next;
        
        while (currentNode1 != currentNode2) {
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next.next;
        }
        
        currentNode1 = head;
        
        while (currentNode1 != currentNode2) {
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }




        return currentNode1;
    }
}
