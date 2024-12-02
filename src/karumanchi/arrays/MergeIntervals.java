package karumanchi.arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mergeIntervals(intervals);
    }

    private static void mergeIntervals(int[][] intervals) {
        int[][] result = new int[intervals.length][2];

        result[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < intervals[i - 1][1]) {
                result[i - 1] = new int[]{intervals[i - 1][0], intervals[i][1]};
            }
        }



        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
