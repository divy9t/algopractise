package karumanchi.arrays;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3};
        System.out.println("Original array: " + Arrays.toString(array));

        nextPermutation(array);
        System.out.println("Next permutation: " + Arrays.toString(array));
    }

    private static void nextPermutation(int[] arr) {

        // first find the pivot element. The pivot element is the element which is smaller than the element to its right
        int pivot = arr.length - 2;
        while (pivot >= 0 && arr[pivot] > arr[pivot+1]) {
            pivot--;
        }

        if (pivot >= 0) {

            int swapIndex = arr.length - 1;


            // if we found pivot now it is time to find the smallest largest element from the array
            while (arr[swapIndex] < arr[pivot]) {
                swapIndex--;
            }

            swapElements(arr, swapIndex, pivot);

        }

        reverseArray(arr, pivot + 1);
    }

    private static void reverseArray(int[] arr, int startIndex) {
        int endIndex = arr.length - 1;

        while ( startIndex < endIndex) {
            swapElements(arr, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    private static void swapElements(int[] arr, int swapIndex, int pivot) {
        int temp = arr[swapIndex];
        arr[swapIndex] = arr[pivot];
        arr[pivot] = temp;
    }
}
