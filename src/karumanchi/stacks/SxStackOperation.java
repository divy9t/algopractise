package karumanchi.stacks;

import karumanchi.linkedlist.Node;
import karumanchi.linkedlist.problems.StackImplementation;

import java.util.Stack;


public class SxStackOperation {
    public static void main(String[] args) {
        Node stack = Node.getSingleLinkedList();
        StackImplementation stackImplementation = new StackImplementation();
        System.out.println(getResultantString(stack, stackImplementation));

    }

    private static String getResultantString(Node stack, StackImplementation stackImplementation) {
    /*
     This index will keep track of whether we already have pushed the mentioned
     number or not, if we did then we won't add new number to the stack.
     */
        StringBuilder result = new StringBuilder();
        int pushIndex = 0;
        for (char c : "365641".toCharArray()) {
            int num = Character.getNumericValue(c);
            // if the num is less than the current number then push it to the stack
            while (pushIndex < num) {
                stack = stackImplementation.push(++pushIndex, stack);
                result.append("S");
            }

            // if the number is equal to the current num then pop it or else give error.
            if (!stackImplementation.isEmpty(stack) && stackImplementation.peek(stack) == num) {
                stack = stackImplementation.pop(stack);
                result.append("X");
            } else
                return "IMPOSSIBLE";

        }
        return result.toString();
    }
}
