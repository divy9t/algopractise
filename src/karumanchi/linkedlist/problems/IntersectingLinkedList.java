package karumanchi.linkedlist.problems;

import karumanchi.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static karumanchi.linkedlist.Node.getNode;

public class IntersectingLinkedList {
    public static void main(String[] args) {
        Node head = getNode(1);
        Node nodeTwo = getNode(2);
        Node nodeThree = getNode(3);
        Node nodeFour = getNode(4);
        Node nodeFive = getNode(5);

        Node nodeSix = getNode(6);
        Node nodeSeven = getNode(7);
        Node nodeEight = getNode(8);

        Node nodeNine = getNode(9);
        Node nodeTen = getNode(10);
        Node nodeEleven = getNode(11);



        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeNine;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = nodeSeven;
        nodeSeven.next = nodeEight;
        nodeEight.next = nodeNine;
        nodeNine.next = nodeTen;
        nodeTen.next = nodeEleven;

        extracted(findIntersectingNodesByBruteForce(head, nodeFour));
        extracted(findInterSectionUsingStack(head, nodeFour));
        extracted(findInterSectionWithMostOptimizedSolution(head, nodeFour));

    }

    private static Node findInterSectionWithMostOptimizedSolution(Node head, Node nodeFour) {
        int nodeOneLength = getLength(head);
        int nodeTwoLength = getLength(nodeFour);

        if (nodeOneLength > nodeTwoLength) {
          return   getInterSectingNode(nodeOneLength - nodeTwoLength, head, nodeFour);
        }
        return getInterSectingNode(nodeTwoLength - nodeOneLength, nodeFour, head);

    }

    private static Node getInterSectingNode(int i, Node biggerNode, Node smallerNode) {
        Node biggerCurrent = biggerNode;
        while (i > 0) {
            biggerCurrent = biggerCurrent.next;
            i--;
        }

        Node smallerCurrent = smallerNode;

        while (smallerCurrent.next != biggerCurrent.next)  {
            smallerCurrent = smallerCurrent.next;
            biggerCurrent = biggerCurrent.next;
        }

        return smallerCurrent.next;
    }

    private static int getLength(Node head) {
        int i = 0;

        Node current = head;
        while (current != null) {
            i ++;
            current = current.next;
        }
        return i;
    }

    private static void extracted(Node intersectingNodesByBruteForce) {
        if (Objects.isNull(intersectingNodesByBruteForce))
            System.out.println("Not intersecting");
        else
            System.out.println("Intersects at: " + intersectingNodesByBruteForce.val);
    }

    private static Node findInterSectionUsingStack(Node head, Node nodeFour) {
        StackImplementation stackImplementation = new StackImplementation();

        Node headStack = getStack(head, stackImplementation);
        Node nodeFourStack = getStack(nodeFour,stackImplementation);

        Node previous = null;
        while (headStack != null && nodeFourStack != null) {
            if (!Objects.equals(stackImplementation.peek(headStack), stackImplementation.peek(nodeFourStack)))
                return previous;
            else
                previous = headStack;
            headStack = stackImplementation.pop(headStack);
            nodeFourStack = stackImplementation.pop(nodeFourStack);
        }
        return previous;
    }

    private static Node getStack(Node head, StackImplementation stackImplementation) {
        Node headStack = new Node(head.val);
        Node current = head.next;

        while (current.next != null){
            headStack = stackImplementation.push(current.val, headStack);
            current = current.next;
        }
        return headStack;
    }

    private static Node findIntersectingNodesByBruteForce(Node headOne, Node headTwo) {
        List<Node> traversedNodes = new ArrayList<>();

        Node headOneCurrent = headOne;
        Node headTwoCurrent = headTwo;

        while (Objects.nonNull(headOneCurrent) || Objects.nonNull(headTwoCurrent)) {
            if (traversedNodes.contains(headOneCurrent) && headOneCurrent != null) {
                return headOneCurrent;
            }else {
                traversedNodes.add(headOneCurrent);
            }

            if (traversedNodes.contains(headTwoCurrent) && headTwoCurrent != null) {
                return headTwoCurrent;
            }else {
                traversedNodes.add(headTwoCurrent);
            }

            if (Objects.nonNull(headOneCurrent)) headOneCurrent = headOneCurrent.next;
            if (Objects.nonNull(headTwoCurrent)) headTwoCurrent = headTwoCurrent.next;
        }

        return null;
    }

}
