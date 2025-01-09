package karumanchi.heap;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] sticks = {2, 4, 3};
        System.out.println(minCostToConnectSticks(sticks));
    }

    private static int minCostToConnectSticks(int[] sticks) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cost = 0;

        for (int i : sticks)
            heap.add(i);

        while (heap.size() > 1) {
            Integer firstNumber = heap.poll();
            Integer secondNumber = heap.poll();
            int costSum = firstNumber + secondNumber;
            cost += costSum;
            heap.add(costSum);
        }
        return cost;
    }
}
