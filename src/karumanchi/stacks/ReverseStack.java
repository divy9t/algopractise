package karumanchi.stacks;


import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
        System.out.println(stack);

    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        // get the first item from the stack
        int firstItem = stack.pop();
        // now we need to reverse the stack if we do it at end then the stack will never be empty
        reverseStack(stack);
        //add item to the end
        addItemToEnd(stack, firstItem);
    }

    private static void addItemToEnd(Stack<Integer> stack, int firstItem) {
        if (stack.isEmpty())
            stack.push(firstItem);
        else {
            // since stack isn't empty, we take the first element out such that the
            // next recursive call can be done with the rest of the stack
            int item = stack.pop();
            // now call add item to the end with one reduced element
            addItemToEnd(stack, firstItem);
            // let's add the reduced element such the correct order is
            // maintained
            stack.push(item);
        }
    }


}
