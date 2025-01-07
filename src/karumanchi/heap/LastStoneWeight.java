package karumanchi.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : stones) {
            heap.add(num);
        }

        while (heap.size() > 1) {
            Integer firstStone = heap.poll();
            Integer secondStone = heap.poll();

            if (firstStone != secondStone) {
                heap.add(firstStone - secondStone);
            }
        }

        if (heap.isEmpty())
            return 0;
        return heap.peek();

    }
}
