package karumanchi.heap.final450;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };

        int[] result = mergeKSortedArrays(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] mergeKSortedArrays(int[][] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int[] ints : arr) {
            for (int anInt : ints) {
                priorityQueue.add(anInt);
            }
        }

        int[] sortedArray = new int[priorityQueue.size()];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            sortedArray[i++] = priorityQueue.poll();
        }
        return sortedArray;
    }
}
