package karumanchi.linkedlist.problems;


import karumanchi.linkedlist.CyclicLinkedListVisualization;
import karumanchi.linkedlist.Node;

import java.util.Objects;

public class CyclicLinkedList {
    public static void main(String[] args) {
        Node cyclicLinkedList = Node.getCyclicLinkedList();
        printResult(isLinkedListCyclic(cyclicLinkedList));
        printResult(isLinkedListCyclic(Node.getSingleLinkedList()));
        System.out.println(
                "Cycle Start At: " + getTheStartOfCyclicNode(cyclicLinkedList).val
        );
        System.out.println(findLoopLength(cyclicLinkedList));
    }

    private static Integer findLoopLength(Node cyclicLinkedList) {
        CyclicLinkedListVisualization.printCyclicLinkedList(cyclicLinkedList);
        if (Objects.isNull(cyclicLinkedList))
            return null;

        Node turtle = cyclicLinkedList;
        Node rabbit = cyclicLinkedList;
        boolean loopExists = false;

        while (turtle != null && rabbit != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                loopExists=true;
                break;
            }
        }

        if (!loopExists )
            return null;

        if (rabbit == null || rabbit.next == null)
            return null;


        turtle = cyclicLinkedList;
        int loopLength = 0;
        while (turtle != rabbit) {
            turtle = turtle.next;
            rabbit = rabbit.next;
        }

        turtle = turtle.next;
        while (turtle != rabbit ) {
            turtle = turtle.next;
            loopLength += 1;
        }
        return loopLength;

    }

    private static Node getTheStartOfCyclicNode(Node cyclicLinkedList) {
        CyclicLinkedListVisualization.printCyclicLinkedList(cyclicLinkedList);
        if (Objects.isNull(cyclicLinkedList))
            return null;

        Node turtle = cyclicLinkedList;
        Node rabbit = cyclicLinkedList;
        boolean loopExists = false;

        while (turtle != null && rabbit != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                loopExists=true;
                break;
            }
        }

        if (!loopExists )
            return null;

        if (rabbit == null || rabbit.next == null)
            return null;


        turtle = cyclicLinkedList;
        while (turtle != rabbit) {
            turtle = turtle.next;
            rabbit = rabbit.next;
        }
        return turtle;
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
        Node rabbit = cyclicLinkedList;

        while (Objects.nonNull(rabbit.next)) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                return true;
            }
        }

        return false;

    }

}
