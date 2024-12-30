package karumanchi.arrays;

import java.util.Arrays;

public class FindMedian {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8};
        int[] arr2 = {7, 9, 10};

        performLogic(arr1, arr2);
    }

    private static void performLogic(int[] arr1, int[] arr2) {

        int[] finalArray = new int[arr1.length + arr2.length];
        int p = 0, q = 0, k = 0;

        while (p < arr1.length && q < arr2.length) {
            if (arr1[p] < arr2[q]) {
                finalArray[k++] = arr1[p++];
            } else {
                finalArray[k++] = arr2[q++];
            }
        }

        while (q < arr2.length) {
            finalArray[k++] = arr2[q++];
        }

        while (p < arr1.length) {
            finalArray[k++] = arr1[p++];
        }


        System.out.println(Arrays.toString(finalArray));
    }

}
