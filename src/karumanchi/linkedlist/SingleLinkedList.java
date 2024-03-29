package karumanchi.linkedlist;

import java.util.Objects;

import static karumanchi.linkedlist.Node.*;

public class SingleLinkedList {
    public static void main(String[] args) {
        Node head = getSingleLinkedList();

        // Insertions
        performInsertion(head);
        //Deletion
        performDeletion(head);
        //Reverse
        reverseLinkedList(head);

    }


    private static void reverseLinkedList(Node head) {

        Node current = head;
        Node next = head.next;

        while (next != null) {
            Node temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        head.next = null;
        head = current;
        printLinkedList(head);
    }

    private static void performDeletion(Node head) {
        Deletion.deleteFirstItem(head);
        Deletion.deleteLastItem(head);
        Deletion.deleteMiddleItem(3, head);
    }

    private static void performInsertion(Node head) {
        Insertion.addItemToFront(0, head);
        Insertion.addItemToLast(6, head);
        Insertion.addItemInMiddle(-4, 3, head);
        System.out.print("\n-- -- -- -- ");
    }


    public static class Insertion {

        private static void addItemInMiddle(int number, int position, Node head) {
            Node newNode = getNode(number);
            if (Objects.isNull(head)) {
                head = newNode;
                System.out.print("\nADD ITEM IN MIDDLE -- ");
                printLinkedList(head);
                return;
            }
            Node positionNode = head;


            while (position > 1 && positionNode.next != null) {
                positionNode = positionNode.next;
                position--;
            }


            if (positionNode.next == null) {
                positionNode.next = newNode;
                System.out.print("\nADD ITEM IN MIDDLE -- ");
                printLinkedList(head);
            }

            Node tempNode = positionNode.next;
            positionNode.next = newNode;
            newNode.next = tempNode;
            System.out.print("\nADD ITEM IN MIDDLE -- ");
            printLinkedList(head);



        }

        private static void addItemToLast(int i, Node nodeOne) {
            if (Objects.isNull(nodeOne)){
                nodeOne = getNode(i);
                System.out.print("\nADD ITEM TO LAST -- ");
                printLinkedList(nodeOne);
                return;
            }

            Node tail = nodeOne.next;
            if (Objects.isNull(tail)) {
                nodeOne.next = getNode(i);
                System.out.print("\nADD ITEM TO LAST -- ");
                printLinkedList(nodeOne);
                return;
            }
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = getNode(i);

            System.out.print("\nADD ITEM TO LAST -- ");
            printLinkedList(nodeOne);
        }

        private static void addItemToFront(int i, Node nodeOne) {
            Node newNode = getNode(i);
            newNode.next = nodeOne;
            nodeOne = newNode;
            System.out.print("\nADD ITEM TO FRONT -- ");
            printLinkedList(nodeOne);
        }
    }

    public static class Deletion {
        private static void deleteMiddleItem(int position, Node head) {
            head = validateDeletion(head);
            if (head == null) return;
            Node positionNode = head;
            while (position > 1 && positionNode.next != null) {
                positionNode = positionNode.next;
                position--;
            }

            if (positionNode.next == null) {
                System.out.print("\nDELETE ITEM FROM MIDDLE -- ");
                printLinkedList(head);
                return;
            }

            positionNode.next = positionNode.next.next;
            System.out.print("\nDELETE ITEM FROM MIDDLE -- ");
            printLinkedList(head);
        }

        private static void deleteLastItem(Node head) {
            head = validateDeletion(head);
            if (head == null) return;

            Node positionNode = head.next;
            while (positionNode.next.next != null) {
                positionNode = positionNode.next;
            }

            positionNode.next = null;
            System.out.print("\nDELETE ITEM FROM LAST -- ");
            printLinkedList(head);

        }

        private static Node validateDeletion(Node head) {
            if (head == null)
                return null;
            if (head.next == null) {
                head = null;
                return null;
            }
            return head;
        }

        private static void deleteFirstItem(Node head) {
            head = validateDeletion(head);
            if (head == null) return;
            head = head.next;
            System.out.print("\nDELETE ITEM FROM FRONT -- ");
            printLinkedList(head);
        }

    }
}
