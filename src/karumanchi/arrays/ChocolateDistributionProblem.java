package karumanchi.arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        performLogic(arr, 5);
    }

    private static void performLogic(int[] arr, int m) {
        Arrays.sort(arr);
        int n = arr.length;

        if (m <= 0) return;
        if (m > n) return;

        int p = 0;
        int q = m -1;

        int minDiff = Integer.MAX_VALUE;
        while (q < n) {
            minDiff = Math.min(minDiff, arr[q] - arr[p]);
            p++;
            q++;
        }

        System.out.println(minDiff);

    }
}
