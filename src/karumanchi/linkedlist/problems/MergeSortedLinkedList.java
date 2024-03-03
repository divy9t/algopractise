package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import static karumanchi.linkedlist.Node.getNode;
import static karumanchi.linkedlist.Node.printLinkedList;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        Node headOne = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);

        Node headTwo = getNode(6);
        Node nodeSeven = getNode(7);
        Node nodeEight = getNode(8);
        Node nodeNine = getNode(9);
        Node nodeTen = getNode(10);

        headOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = null;

        headTwo.next = nodeSeven;
        nodeSeven.next = nodeEight;
        nodeEight.next = nodeNine;
        nodeNine.next = nodeTen;

        printLinkedList(mergeSortedLinkedList(headOne, headTwo));

    }

    private static Node mergeSortedLinkedList(Node headOne, Node headTwo) {
        Node result = new Node();
        if (headOne == null) return headTwo;
        if (headTwo == null) return headOne;


        if (headOne.val < headTwo.val) {
            result.val = headOne.val;
            result.next = mergeSortedLinkedList(headOne.next, headTwo);
        } else {
            result.val = headTwo.val;
            result.next = mergeSortedLinkedList(headOne, headTwo.next);
        }


        return result;

    }
}
