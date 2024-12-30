package karumanchi.arrays;

import java.util.Arrays;

public class ThreeWayPartition {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 1};
        performLogic(arr, 1, 3);
    }

    private static void performLogic(int[] arr, int a, int b) {
        int low = 0,i  = 0, n = arr.length, high = n - 1;


        while (i <= high) {
            if (arr[i] < a) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] > b) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
