package karumanchi.heap;

import java.util.*;

public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        int k = 3;
        System.out.println(Arrays.toString( kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
       Map<Integer, Integer> counter = new HashMap<>();

       for (int i = 0;i < mat.length; i++ ){
           int count = 0;
           for (int j:mat[i]) {
               if (j != 1)
                   break;
               count++;
           }
           counter.put(i, count);
       }


       PriorityQueue<int[]> heap = new PriorityQueue<>(
               (a,b) -> {
                   if (a[0] == b[0]) return a[1] - b[1];
                   return a[0] - b[0];
               }
       );

       for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
           heap.add(new int[]{entry.getValue(), entry.getKey()});
       }

       int[] result = new int[k];

       for (int i = 0; i<k;i++) {
           result[i] = heap.poll()[1];
       }

       return result;
    }

}
