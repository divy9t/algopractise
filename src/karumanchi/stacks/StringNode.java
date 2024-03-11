package karumanchi.stacks;

import karumanchi.linkedlist.Node;

public class StringNode {
    public String val;
    public StringNode next;
    public StringNode prev;

    public StringNode() {}

    public StringNode(String val) {
        this.val = val;
    }


    public StringNode(String val, StringNode next) {
        this.val = val;
        this.next = next;
    }

    public static StringNode getNode(String i) {
        return new StringNode(i);
    }
    public static void printLinkedList(StringNode head) {
        StringNode current = head;
        System.out.print("Values:");
        while (current != null) {
            System.out.print(" "+current.val);
            current = current.next;
        }
    }
    public static void circularLinkedList(StringNode head) {
        StringNode current = head;
        System.out.print("Values:");
        while (current != null) {
            System.out.print(" "+current.val);
            current = current.next;
            if (current == head)
                break;
        }
    }
    public static void printForward(StringNode head) {
        System.out.print("\nForward: ");
        StringNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void printBackward(StringNode tail) {
        System.out.print("\nBackward: ");
        StringNode current = tail;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.prev;
        }
        System.out.println();
    }
    public static void printBackwardForward(StringNode head) {
        System.out.print("\nForward: ");
        StringNode tail = null ;
        StringNode current = head;
        while (current != null) {
            tail = current;
            System.out.print(current.val + " ");
            current = current.next;
        }
        printBackward(tail);
    }

    public static StringNode getSingleLinkedList() {
        StringNode head = getNode("1");
        StringNode nodeTwo = getNode("2");
        StringNode nodeThree = getNode("3");
        StringNode nodeFour = getNode("4");
        StringNode nodeFive = getNode("5");

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = null;
        return head;
    }


}
