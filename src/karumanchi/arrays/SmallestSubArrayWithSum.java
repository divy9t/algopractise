package karumanchi.arrays;

public class SmallestSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int target = 51;

        performLogic(arr, target);
    }

    private static void performLogic(int[] arr, int target) {
        int p = 0;
        int currentSum = 0;
        int minWindow = Integer.MAX_VALUE;

        for (int q = 0; q < arr.length; q++) {
            currentSum += arr[q];

            while (currentSum > target) {
                minWindow = Math.min(minWindow, q - p + 1);

                currentSum -= arr[p];
                p++;
            }
        }

        if (minWindow == Integer.MAX_VALUE)
            System.out.println("No Min sum exists");
        else
            System.out.println("Min sum exists");

    }
}
