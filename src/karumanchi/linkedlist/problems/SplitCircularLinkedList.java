package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import java.util.Objects;

public class SplitCircularLinkedList {

    public static void main(String[] args) {

        splitCircularList(Node.getCircularLinkedList());
    }

    private static void splitCircularList(Node circularLinkedList) {
        Node.circularLinkedList(circularLinkedList);
        Node snail = circularLinkedList;
        Node rabbit = circularLinkedList;

        while (snail != null) {
            if (rabbit.next == circularLinkedList) {
                break;
            }
            rabbit = rabbit.next;
            if (rabbit == null || rabbit.next == circularLinkedList)
                break;

            rabbit = rabbit.next;
            snail = snail.next;

        }

        if (Objects.isNull(snail)) {
            System.out.println("Something wrong");
            return;
        }

        rabbit.next = null;
        Node listOne = snail.next;
        System.out.println("\nFirst List: ");
        Node.printLinkedList(listOne);
        snail.next = null;
        System.out.println("\nSecond List: ");
        Node.printLinkedList(circularLinkedList);


    }
}
