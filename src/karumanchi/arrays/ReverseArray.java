package karumanchi.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
        reverseArrayHalfLoopApproach(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    //using two pointers approach
    private static void reverseArray(int[] arr) {
        int p = 0;
        int q = arr.length - 1;

        while (p < q ) {
            int temp = arr[p];
            arr[p] = arr[q];
            arr[q] = temp;
            p += 1;
            q -= 1;
        }
    }

    //using half loop approach
    private static void reverseArrayHalfLoopApproach(int[] arr) {
        for (int i=0; i < arr.length - 1; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

    }
}
