package karumanchi.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomProblem {
    public static void main(String[] args) {
        int[][] intervals = {{9,10}, {4, 9}, {4, 17}};
        System.out.println(minMeetingRooms(intervals));
    }

    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval[0])
                heap.poll();

            heap.add(interval[1]);
        }

        return heap.size();
    }

}