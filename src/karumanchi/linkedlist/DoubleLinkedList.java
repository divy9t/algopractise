package karumanchi.linkedlist;

import java.util.Objects;

import static karumanchi.linkedlist.Node.*;

public class DoubleLinkedList {

    public static void main(String[] args) {
        Node head = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);

        head.next = nodeTwo;
        nodeTwo.prev = head;

        nodeTwo.next = nodeThree;
        nodeThree.prev = nodeTwo;

        nodeThree.next = nodeFour;
        nodeFour.prev = nodeThree;

        nodeFour.next = nodeFive;
        nodeFive.prev = nodeFour;

        nodeFive.next = null;

        //insertion
        addDoubleLinkedListItemToFront(0, head);
        addDoubleLinkedListItemToList(6, head);
        addDoubleLinkedListItemToPosition(-4, 3, head);

        //deletion
        deleteItemFromFrontList(head);
        deleteItemFromLastList(head);
        deleteItemFromPositionList(3, head);
    }

    private static void deleteItemFromPositionList(int position, Node head) {
        System.out.println("DELETING NODE FROM POSITION NODE");
        printBackwardForward(head);
        if (Objects.isNull(head))
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node positionNode = head;
        while ( position > 1 && positionNode.next != null) {
            positionNode = positionNode.next;
            position--;
        }

        if (positionNode.prev == null) {
            deleteItemFromFrontList(head);
            printBackwardForward(head);
            return;
        }

        if (positionNode.next == null) {
            deleteItemFromLastList(head);
            printBackwardForward(head);
            return;
        }

        positionNode.next = positionNode.next.next;
        positionNode.next.prev = positionNode;
        printBackwardForward(head);
    }

    private static void deleteItemFromLastList(Node head) {
        System.out.println("DELETING NODE FROM LAST");
        if (Objects.isNull(head))
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        if (tail.prev == null)
            return;

        Node prev = tail.prev;
        prev.next.prev = null;
        prev.next = null;

        printBackwardForward(head);

    }

    private static void deleteItemFromFrontList(Node head) {
        System.out.println("DELETING NODE FROM FRONT");
        if (Objects.isNull(head))
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
        printBackwardForward(head);

    }

    private static void addDoubleLinkedListItemToPosition(int i, int position, Node head) {
        System.out.println("Printing Addition to Position");
        if (i == 0 || Objects.isNull(head)) {
            addDoubleLinkedListItemToFront(i, head);
            return;
        }
        if (head.next == null) {
            addDoubleLinkedListItemToList(i, head);
            return;
        }

        Node newNode = getNode(i);
        Node positionNode = head;
        while (position > 1 && positionNode.next != null) {
            positionNode = positionNode.next;
            position--;
        }
        newNode.prev = positionNode;
        Node temp = positionNode.next;
        positionNode.next = newNode;
        newNode.next = temp;
        if (temp != null) temp.prev = newNode;

        printBackwardForward(head);
    }

    private static void addDoubleLinkedListItemToList(int i, Node head) {

        System.out.println("Printing Addition to Last");
        Node newNode = getNode(i);
        if (Objects.isNull(head))
            head = getNode(i);
        Node tail = head;
         while (tail.next != null) {
             tail = tail.next;
         }
         newNode.prev = tail;
         newNode.next = null;
         tail.next = newNode;
         printBackwardForward(head);

    }

    private static void addDoubleLinkedListItemToFront(int i, Node head) {
        System.out.println("Printing Addition to Front");
        Node newNode = getNode(i);
        if (Objects.isNull(head))
            head = getNode(i);

        newNode.next = head;
        head = newNode;
        printLinkedList(head);
    }


}
