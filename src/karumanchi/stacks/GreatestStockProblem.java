package karumanchi.stacks;

import java.util.Arrays;
import java.util.Stack;

public class GreatestStockProblem {

    public static void main(String[] args) {

        int[] s = findSpans(new int[]{6,3,4,5,2}, 5);
        System.out.println(Arrays.toString(s));
    }

    private static int[] findSpans(int[] A, int num) {

        int[] result = new int[A.length];

        for (int i = 0; i < num; i++) {
            int j = 1;

            //the current day should be less than or equal to the day in iteration
            //The stock price of the current day should be greater than the stock price on jth day

            // we used the while loop here because we wanted to keep adding the value till
            // the condition doesn't break
            while (j <= i && A[i] > A[i-j])
                j = j + 1;

            result[i] = j;
        }

        return result;

    }
}
