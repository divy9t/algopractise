package karumanchi.linkedlist;

import easy.object.ListNode;

public class Node {
    public Integer val;
    public Node next;
    public Node prev;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }


    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node getNode(int i) {
        return new Node(i);
    }
    public static void printLinkedList(Node head) {
        Node current = head;
        System.out.print("Values:");
        while (current != null) {
            System.out.print(" "+current.val);
            current = current.next;
        }
    }
    public static void circularLinkedList(Node head) {
        Node current = head;
        System.out.print("Values:");
        while (current != null) {
            System.out.print(" "+current.val);
            current = current.next;
            if (current == head)
                break;
        }
    }
    public static void printForward(Node head) {
        System.out.print("\nForward: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void printBackward(Node tail) {
        System.out.print("\nBackward: ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.prev;
        }
        System.out.println();
    }
    public static void printBackwardForward(Node head) {
        System.out.print("\nForward: ");
        Node tail = null ;
        Node current = head;
        while (current != null) {
            tail = current;
            System.out.print(current.val + " ");
            current = current.next;
        }
        printBackward(tail);
    }


    public static Node getSingleLinkedList() {
        Node head = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = null;
        return head;
    }

    public static Node getCyclicLinkedList() {
        Node head = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeThree;
        return head;
    }

    public static Node getCircularLinkedList() {
        Node head = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);
        Node nodeSix = getNode(6);

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = head;
        return head;
    }

}
