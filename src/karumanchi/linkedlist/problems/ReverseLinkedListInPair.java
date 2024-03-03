package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import java.util.Objects;

public class ReverseLinkedListInPair {

    public static void main(String[] args) {


        Node.printLinkedList(reverseLinkedList(Node.getSingleLinkedList()));
        Node.printLinkedList(reverseLinkedListInPair(Node.getSingleLinkedList(), 8));
    }

    private static Node reverseLinkedList(Node singleLinkedList) {
        Node current = singleLinkedList;
        Node prev = null;
        while (current.next != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }
        current.next = prev;
        System.out.println("\n-----------------");
        return current;
    }
    private static Node reverseLinkedListInPair(Node singleLinkedList, int count) {
        System.out.println("\n-----------------");
        if (singleLinkedList == null) return null;
        Node current = singleLinkedList;
        Node prev = null;
        int tempCount = count;
        while (tempCount > 1 && current.next != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            tempCount--;
        }
        if (prev == null) return current;
        singleLinkedList.next = reverseLinkedListInPair(current.next , count);
        current.next = prev;
        return current;
    }


}
