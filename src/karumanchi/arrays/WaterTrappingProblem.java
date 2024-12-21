package karumanchi.arrays;

public class WaterTrappingProblem {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        int n = arr.length;

        performLogic(arr, n);

    }

    private static void performLogic(int[] arr, int n) {
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        int[] rightMax = new int[arr.length];
        rightMax[n-1] = arr[n-1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], rightMax[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++){
            result += Math.min(rightMax[i], leftMax[i]) - arr[i];

        }

        System.out.println(result);
    }
}
