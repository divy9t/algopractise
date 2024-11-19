package karumanchi.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindkMaxMin {
    public static void main(String[] args) {
        int[] arr = {11, 13, 23, 12, 5};
        findKMinElement(arr, 1);
        findKMaxElement(arr, 2);
    }

    private static void findKMaxElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        System.out.println("Kth Largest Element: " + priorityQueue.peek());
    }

    private static void findKMinElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        System.out.println("Kth Smallest Element: " + priorityQueue.peek());

    }
}
