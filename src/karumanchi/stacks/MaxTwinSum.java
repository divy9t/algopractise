package karumanchi.stacks;

import karumanchi.linkedlist.Node;

import java.sql.Array;
import java.util.Stack;

public class MaxTwinSum {
    public static void main(String[] args) {
        Node head = new Node();
        head.val = 5;
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

//        System.out.println(new MaxTwinSum().pairSum(head));
        System.out.println(new MaxTwinSum().pairSum(getLinkedList(new int[]{4,2,2,3})));
        System.out.println(new MaxTwinSum().pairSum(getLinkedList(new int[]{47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9})));


    }

    private static Node getLinkedList(int[] array) {
        if (array.length == 0) {
            return new Node();
        }

        Node head = new Node(array[0]);
        Node current = head;
        int i = 0;
        for (i = 1; i < array.length; i++) {
            current.next = new Node(array[i]);
            current = current.next;
        }

        return head;
    }

    public int pairSum(Node head) {
        if (head.next.next == null)
            return head.val + head.next.val;

        Stack<Integer> stack = new Stack<>();

        //using the rabbit and hare algorithm here
        Node hare = head;
        Node rabbit = head.next.next;

        //filling the stack with the first half of the elements
        while (rabbit != null) {
            stack.push(hare.val);
            hare = hare.next;
            rabbit = rabbit.next.next;
            if (rabbit == null)
                stack.push(hare.val);
        }

        //moving the slow pointer since it already placed the element in stack
        hare = hare.next;
        int maxSum = 0;

        //post the above operation the hare becomes the twin of the stack elements
        while ( ! stack.isEmpty() && hare != null) {
            Integer pop = stack.pop();
            int newValue = pop + hare.val;
            maxSum = Math.max(newValue, maxSum);
            hare = hare.next;
        }

        return maxSum;
    }

}
