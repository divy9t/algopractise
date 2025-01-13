package karumanchi.heap.final450;

import java.util.PriorityQueue;

public class SmallestRangeInKList {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        findSmallestRange(arr, 4, 3);
    }

    private static void findSmallestRange(int[][] arr,int n,int k) {
        int p=0, q=0, r=0, smallestWindow=0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    }
}
