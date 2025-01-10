package karumanchi.heap.final450;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxofAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5};
        int k = 3;
        printMaxOfAllSubArrays(arr, k);
    }

    private static void printMaxOfAllSubArrays(int[] arr, int k) {

        int p = 0;
        int q = k;
        PriorityQueue<Integer> priorityQueue;
        while (q < arr.length) {
            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = p; i < q; i++) {
                priorityQueue.add(arr[i]);
            }
            System.out.println(priorityQueue.poll());
            p++;
            q++;
        }

        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        while (p < arr.length) {
            priorityQueue.add(arr[p]);
            p++;
        }
        System.out.println(priorityQueue.poll());

    }
}
