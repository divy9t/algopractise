package karumanchi.heap.final450;

import java.util.PriorityQueue;

public class kLargestElements {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        printKLargestElements(arr, k);

    }

    private static void printKLargestElements(int[] arr, int k) {
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

        System.out.println(priorityQueue);
    }
}
