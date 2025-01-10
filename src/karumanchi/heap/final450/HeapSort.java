package karumanchi.heap.final450;

import java.util.Arrays;

public class HeapSort {



    public static void sort(int[] array) {
        for (int i = array.length/2 - 1; i >= 0; i--) {
            maxHeapify(array, array.length, i);
        }

        for (int i = array.length - 1; i > 0; i-- ) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, i, 0);

        }

        System.out.println(Arrays.toString(array));
    }

    private static void maxHeapify(int[] array, int length, int currentLargest) {
       int left = currentLargest * 2 + 1;
       int right = currentLargest * 2 + 2;

       int largest = currentLargest;

       if (left < length && array[largest] < array[left])
           largest = left;

       if (right < length && array[largest] < array[right])
           largest = right;

       if (largest != currentLargest) {
           swapElement(array, currentLargest, largest);
           maxHeapify(array, left, largest);
       }


    }

    private static void swapElement(int[] heap,int parent, int index) {
        int temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,9};
        sort(arr);
    }

}
