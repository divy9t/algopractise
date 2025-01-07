package karumanchi.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinKSmallestElementInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));

    }

    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] i : matrix) {
            for (int j : i) {
                heap.add(j);
                if (heap.size() > k) {
                    heap.poll();
                }

            }
        }
        return heap.peek();
    }
}
