package karumanchi.heap;

import java.util.PriorityQueue;

public class KthLargest {
    Integer k;
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for (int num : nums) {
            if (heap.size() < k)
                heap.add(num);
            else if (heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }
    }


    public int add(int val) {
        heap.add(val);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }


    public static void main(String[] args) {
        int[] arr = {7,7,7,7,8,3};
        int k = 4;
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(9));
    }
}
