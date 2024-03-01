package karumanchi.linkedlist.problems;


import karumanchi.linkedlist.Node;

import java.util.Objects;

public class CyclicLinkedList {
    public static void main(String[] args) {
        Node.getCyclicLinkedList();
        printResult(isLinkedListCyclic(Node.getCyclicLinkedList()));
        printResult(isLinkedListCyclic(Node.getSingleLinkedList()));
    }

    private static void printResult(boolean cyclic) {
        if (cyclic) System.out.println("Linked List Is Cyclic");
        else System.out.println("Linked List Is non-cyclic");
    }

    //This method is called Floyd's Cycle Detection Algorithm
    private static boolean isLinkedListCyclic(Node cyclicLinkedList) {
        if (Objects.isNull(cyclicLinkedList))
            return false;

        Node turtle = cyclicLinkedList;
        Node rabbit = cyclicLinkedList.next.next;

        while (Objects.nonNull(rabbit.next)) {
            if (turtle == rabbit) {
                return true;
            }
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }

        return false;

    }

}
