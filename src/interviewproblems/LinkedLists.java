package interviewproblems;

import java.util.HashSet;

public class LinkedLists {

    class Node {

        Node next = null;
        int value;

        Node(int value) {
            this.value = value;
        }

    }

    /**
     * Add an integer to the end of the list
     */
    public void append(Node current, int d) {
        Node last = new Node(d);
        Node existent = null;
        while (current.next != null) {
            if (current.value == d) {
                existent = current;
            }
            current = current.next;
        }
        if (existent != null) {
            current.next = existent;
            return;
        }
        current.next = last;
    }

    /**
     * Delete an element with a given value
     */
    public Node delete(Node head, int valueToDelete) {
        Node currentNode;
        Node nextNode;

        //if null linked list terminate
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
     * Display a linked list
     */
    public void display(Node current) {
        if (current == null) {
            System.out.println("Lista goala");
            return;
        }
        while (current.next != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println(current.value);
    }

    /**
     * 2.1 Write code to remove duplicates from an unsorted linked list. FOLLOW
     * UP How would you solve this problem if a temporary buffer is not allowed?
     */
    public void removeDuplicates(Node head) {
        Node currentNode = head;
        Node nextNode;
        //a list with 0 or 1 elements has no duplicates
        if (head == null || head.next == null) {
            return;
        }
        while (currentNode != null && currentNode.next != null) {
            nextNode = currentNode;
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
    public Node nthElement(Node head, int nth) {
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
    public Node addLists(Node list1, Node list2) {
        Node sumList = new Node(0);
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
            this.append(sumList, sum);
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
                this.append(sumList, sum);
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
                this.append(sumList, sum);
                list2 = list2.next;
            }
        }

        if (carry) {
            this.append(sumList, 1);
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
    public Node loopStart(Node head) {
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
