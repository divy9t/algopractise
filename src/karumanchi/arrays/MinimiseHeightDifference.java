package karumanchi.arrays;

import java.util.Arrays;

public class MinimiseHeightDifference {

    public static void main(String[] args) {
        int[] arr ={1, 5, 8, 10};
        int k = 2;
        System.out.println(minimiseHeightDifference(arr, k));
    }

    private static Integer minimiseHeightDifference(int[] arr, int k) {
        Arrays.sort(arr);

        int minimizedDifference = arr[arr.length - 1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            int maxResult = Math.max(arr[arr.length - 1] - k, arr[i] + k);
            int minResult = Math.min(arr[0] + k, arr[i + 1] - k);

            minimizedDifference = Math.min(minimizedDifference, maxResult - minResult);
        }

        return minimizedDifference;
    }
}
