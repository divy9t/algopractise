package karumanchi.heap.final450;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestSum {
    public static void main(String[] args) {
        int[] a = {-40, -10, 10, 20};
        int k = 6;

        findKthLargestSum(a, k);


    }

    private static void findKthLargestSum(int[] a, int k) {
        int[] prefixSum = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }
        System.out.println(Arrays.toString(prefixSum));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int currentSum = prefixSum[j + 1] - prefixSum[i];
                if (priorityQueue.size() < k) {
                    priorityQueue.add(currentSum);
                } else if (priorityQueue.peek() < currentSum) {
                    priorityQueue.poll();
                    priorityQueue.add(currentSum);
                }
            }
        }

        System.out.println(priorityQueue.poll());
    }
}
