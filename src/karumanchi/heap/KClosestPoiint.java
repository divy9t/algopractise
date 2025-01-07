package karumanchi.heap;

import java.util.PriorityQueue;

public class KClosestPoiint {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = kClosest(points, k);
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }

    /*
    new PriorityQueue<>(
                        (a,b) -> {
                            if ((a[0]^2 + a[1]^2) > (b[0]^2 + b [1]^2)) return -1;
                            else if ((a[0]^2 + a[1]^2) < (b[0]^2 + b [1]^2)) return 1;
                            return 0;
                        }

                );
     */
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));


        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k ) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }

        return  result;
    }
}
