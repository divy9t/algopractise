package karumanchi.arrays;

import java.util.Arrays;
import java.util.Objects;

public class FindCommonInThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        findCommon(arr1, arr2, arr3);
    }

    private static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
        int point1 = 0, point2 = 0, point3 = 0;
        int pointer = 0;
        int[] result = new int[Math.min(arr1.length, Math.min(arr2.length, arr3.length))];


        while (point1 < arr1.length && point2 < arr2.length && point3 < arr3.length) {
            // If the current elements are equal
            if (arr1[point1] == arr2[point2] && arr2[point2] == arr3[point3]) {
                result[pointer++] = (arr1[point1]);
                point1++;
                point2++;
                point3++;
            }
            // Increment the pointer of the smallest value
            else if (arr1[point1] < arr2[point2]) {
                point1++;
            } else if (arr2[point2] < arr3[point3]) {
                point2++;
            } else {
                point3++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
