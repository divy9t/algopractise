package karumanchi.stacks;

import java.util.Arrays;
import java.util.Stack;

public class GreatestStockProblem {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findSpans(new int[]{6, 3, 4, 5, 2}, 5)));
        System.out.println(Arrays.toString(findSpanUsingStack(new int[]{6, 3, 4, 5, 2}, 5)));
    }

    private static int[] findSpans(int[] A, int num) {

        int[] result = new int[A.length];

        for (int i = 0; i < num; i++) {
            int j = 1;

            //the current day should be less than or equal to the day in iteration
            //The stock price of the current day should be greater than the stock price on jth day

            // we used the while loop here because we wanted to keep adding the value till
            // the condition doesn't break
            while (j <= i && A[i] > A[i - j])
                j = j + 1;

            result[i] = j;
        }

        return result;

    }

    private static int[] findSpanUsingStack(int[] A, int num) {

        int[] result = new int[A.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;

        for (int i=0; i < num; i++) {
            /*
            if the stack is not empty and the current element in the stack is greater than the
            top element of the stack, then we will pop the stack ensuring that only the greater element
            stays in the stack
             */
            while (!stack.isEmpty() && A[stack.peek()] <= A[i] ) {
                stack.pop();
            }


            /*
            if stack is empty then it means the current element is the largest element,
            if not then it is greater than the ith element
             */
            result[i] = stack.isEmpty() ? i + 1: i - stack.peek();

            /*
            push the current element in stack
             */
            stack.push(i);

        }

        return result;

    }
}
