package karumanchi.heap.final450;

import java.util.Arrays;

public class MergeBinaryMaxHeap {
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 6, 2};
        int[] arr2 = {12, 7, 9};

        int[] arr3 = new int[arr1.length + arr2.length];

        int newArrayLength = 0;
        for (int i = 0;i < arr1.length ; i++){
            arr3[i] = arr1[i];
            newArrayLength++;
        }

        for (int j : arr2) {
            arr3[newArrayLength++] = j;

        }

        for (int  i = arr3.length/ 2 - 1 ; i >= 0; i--) {
            maxHeapify(arr3, arr3.length, i);
        }


        System.out.println(Arrays.toString(arr3));

    }

    public static void maxHeapify (int[] arr, int length, int largestIndex) {
        int left = 2 * largestIndex + 1;
        int right = 2 * largestIndex + 2;

        int largest = largestIndex;

        if (left < length && arr[largestIndex] < arr[left]) {
            largest = left;
        }

        if (right < length && arr[largestIndex] < arr[right]) {
            largest = right;
        }

        if (largest != largestIndex) {
            swapElement(arr, largest, largestIndex);
            maxHeapify(arr, length, largest);
        }

    }

    private static void swapElement(int[] heap,int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
