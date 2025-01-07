package karumanchi.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {4,1,-1,2,-1,2,3};
        int k = 2;
        printTopKFrequent(arr, k);
    }

    private static int[] printTopKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : nums) {
            counter.putIfAbsent(i, 0);
            counter.put(i, counter.get(i) + 1);
        }

        if (counter.keySet().size() < k) {
            return counter.keySet().stream().mapToInt(i -> i).toArray();
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(counter::get)
        );

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry.getKey());
            } else if (counter.get(heap.peek()) < counter.get(entry.getKey())) {
                heap.poll();
                heap.add(entry.getKey());
            }
        }

        System.out.println(heap);
        return heap.stream().mapToInt(i -> i).toArray();

    }
}
