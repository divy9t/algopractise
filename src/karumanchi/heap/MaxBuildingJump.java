package karumanchi.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxBuildingJump {
    public static void main(String[] args) {
        int ladders = 1;
        int bricks = 5;
        int[] buildings = {4,2,7,6,9,14,12};
        System.out.println(maxBuildingJump(ladders, bricks, buildings));
    }

    // the key lies in re-claiming the ladder
    private static int maxBuildingJump(int ladders, int bricks, int[] heights) {
        if (heights.length <= 1)
            return 0;


        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxBuilding = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                heap.add(diff);

                if (heap.size() > ladders) {
                    Integer minimumHeight = heap.poll();
                    if (minimumHeight <= bricks) {
                        bricks -= minimumHeight;
                    } else {
                        return maxBuilding;
                    }
                }

            }

            maxBuilding++;


        }

        return maxBuilding;
    }
}
