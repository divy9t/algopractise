package karumanchi.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,9};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    private static void maxHeapify(int[] arr, int length, int index) {

        int left = 2 * index  + 1;
        int right = 2 * index  + 2;
        int largest = index;

        if (left < length && arr[left] > arr[index])
            largest = left;

        if (right < length && arr[right] > arr[index])
            largest = right;

        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            maxHeapify(arr, length, largest);
        }
    }

}
