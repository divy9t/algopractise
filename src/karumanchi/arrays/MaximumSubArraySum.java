package karumanchi.arrays;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(arr));
    }

    private static boolean maxSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0, start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }

        }

        for (int i = start; i <= end; i ++) {
            System.out.print(arr[i] + " ");
        }

        return true;

    }


}
