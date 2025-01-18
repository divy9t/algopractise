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
    // Sort the intervals by start time
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    // Min-heap to keep track of end times of meetings
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    // Iterate over all the intervals
    for (int[] interval : intervals) {
        // If the room due to free up the earliest is free, assign that room to this meeting
        if (!heap.isEmpty() && heap.peek() <= interval[0])
            heap.poll();

        // If a new room is to be assigned, then also we add to the heap
        heap.add(interval[1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings
    return heap.size();
}

}