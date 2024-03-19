package karumanchi.stacks;

import java.util.Stack;

public class LargestRectengleArea {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));  // Output: 10
    }

    private static Integer largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while ( i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
                stack.push(i++);
            else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? 1 : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? 1 : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
}
