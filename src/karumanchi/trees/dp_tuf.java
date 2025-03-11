package karumanchi.trees;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.abs;

@SuppressWarnings("unused")
public class dp_tuf {

    public static void main(String[] args) {
        dp_tuf dpTuf = new dp_tuf();
//        System.out.println(dpTuf.frogJumpOld(new int[]{3, 10, 3, 11, 3}));
//        System.out.println(dpTuf.frogJump(new int[]{10, 5, 20, 0, 15}, 2));
//        System.out.println(dpTuf.solveFrogJumpVariableTabulation(new int[]{10, 5, 20, 0, 15}, 2));
//        System.out.println(dpTuf.fib(6));
//        System.out.println(dpTuf.climbStairs(7));
//        System.out.println(dpTuf.nonAdjacent(new int[]{184,534,151,759,259,991,871,61,49,95,283,556,372,946,975,216,32,18,766,137,874,817,435,350,651,263,731,712,131,364,284,35,800,243,882,163,52,337,741,129,884,917,596,677,201,564,885,706,327,285,355}));
//        System.out.println(dpTuf.ninjaTraining(new int[][]{{20, 10, 10}, {20, 10, 10}, {20, 30, 10}}));
        System.out.println(dpTuf.uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(solveUniquePaths(m - 1, n - 1, map));
       int[][] dp = new int[m][n];

        // Base case: Only one way to reach the first row/column
        for (int i = 0; i < m; i++) dp[i][0] = 1; // First column
        for (int j = 0; j < n; j++) dp[0][j] = 1; // First row

       for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
           }
       }

       return dp[m - 1][n - 1];
    }

    public int solveUniquePaths(int m, int n, HashMap<String, Integer> map) {
        String key = m + "_" + n;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (map.containsKey(key)) return map.get(key);
        int left = solveUniquePaths(m, n - 1, map);
        int up = solveUniquePaths(m - 1, n, map);

        int i = left + up;
        map.put(key, i);
        return i;
    }


    public int ninjaTraining(int[][] matrix) {
        return solveNinjaTraining(matrix, matrix.length - 1, -1, new HashMap<>());
    }


    private int solveNinjaTraining(int[][] matrix, int day, int lastActivity, HashMap<String, Integer> map) {
        if (day == 0) {
            int result = 0;
            for (int currentActivity = 0; currentActivity <= 2; currentActivity++) {
                if (lastActivity == currentActivity) continue;
                result = Math.max(result, matrix[day][currentActivity]);
            }
            return result;
        }
        String key = day + "_" + lastActivity;
        if (map.get(key) != null) {
            System.out.println("Found");
            return map.get(key);
        }
        int max = 0;
        for (int currentActivity = 0; currentActivity <= 2; currentActivity++) {
            if (currentActivity == lastActivity) continue;
            int result = matrix[day][currentActivity] + solveNinjaTraining(matrix, day - 1, currentActivity, map);
            max = Math.max(result, max);


        }
        map.put(key, max);
        return max;


    }

    public int nonAdjacent(int[] nums) {
        if (nums.length - 1 == 0) return nums[0];
        if (nums.length - 1 == 1) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveNonAdjacent(nums, nums.length - 1, dp);
    }

    public int nonAdjacentTab(int[] nums) {
        if (nums.length == 1) return nums[0];
        long[] dp = new long[nums.length];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 1; i <= nums.length - 1; i++) {
            long exclude = dp[i - 1];
            long include = Integer.MIN_VALUE;
            if (i > 1) include = dp[i - 2] + nums[i];
            dp[i] = Math.max(exclude, include);
        }

        return (int) dp[nums.length - 1];
    }


    public int solveNonAdjacent(int[] nums, int index, int[] dp) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];

        if (dp[index] != -1) return dp[index]; // Memoization check

        int exclude = solveNonAdjacent(nums, index - 1, dp);
        int include = (index >= 2 ? solveNonAdjacent(nums, index - 2, dp) : 0) + nums[index];

        dp[index] = Math.max(exclude, include);
        return dp[index];
    }

    private int frogJump(int[] ints, int varableJump) {
        int[] res = new int[ints.length];
        Arrays.fill(res, -1);
        return solveFrogJumpVariable(ints, ints.length - 1, varableJump, res);

    }


    private int solveFrogJumpVariableTabulation(int[] heights, int variableJump) {
        int[] res = new int[heights.length];
        res[0] = 0;


        for (int i = 1; i < heights.length; i++) {
            int first = res[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= variableJump; j++) {
                int sol;
                if (j <= i) {
                    sol = res[i - j] + Math.abs(heights[j] - heights[j - i]);
                    if (min > sol) min = sol;
                }

            }
            res[i] = Math.min(min, first);

        }

        return res[heights.length - 1];

    }

    private int solveFrogJumpVariable(int[] heights, int n, int variableJump, int[] res) {
        if (n == 0) return 0;
        if (res[n] != -1) return res[n];

        int min = Integer.MAX_VALUE;

        int first = solveFrogJumpVariable(heights, n - 1, variableJump, res) + Math.abs(heights[n] - heights[n - 1]);
        for (int i = 1; i <= variableJump; i++) {
            int sol;
            if (i <= n) {
                sol = solveFrogJumpVariable(heights, n - i, variableJump, res) + Math.abs(heights[n] - heights[n - i]);
                if (min > sol) min = sol;
            }

        }

        res[n] = Math.min(min, first);
        return res[n];

    }


    public int frogJumpOld(int[] heights) {
        solveFrogJumpViaTabulation(heights);
        return solveFrogJump(heights, heights.length - 1, new int[heights.length]);

    }

    public int solveFrogJump(int[] heights, int n, int[] res) {
        if (n == 0) return 0;
        if (res[n] != 0) return res[n];

        int first = solveFrogJump(heights, n - 1, res) + Math.abs(heights[n] - heights[n - 1]);
        int second = Integer.MAX_VALUE;

        if (n > 1)
            second = solveFrogJump(heights, n - 2, res) + Math.abs(heights[n] - heights[n - 2]);

        int min = Math.min(first, second);
        res[n] = min;
        return res[n];


    }

    public int solveFrogJumpViaTabulation(int[] heights) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < heights.length; i++) {
            int first = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int second = Integer.MAX_VALUE;
            if (i > 1)
                second = prev2 + Math.abs(heights[i] - heights[i - 2]);

            prev2 = prev1;
            prev1 = Math.min(first, second);

        }
        return prev1;


    }


    private int fib(int n) {
        return fib(n, new int[n + 1]);
    }

    private int fib(int n, int[] dp) {
        if (n == 1 || n == 0) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {
        int i = solveViaTabulation(n);
        System.out.println(i);
        return solveViaMemoization(n, new int[n + 1]);

    }

    public int solveViaMemoization(int n, int[] res) {
        if (n == 0 || n == 1) return 1;
        if (res[n] != 0) return res[n];

        int i = solveViaMemoization(n - 1, res) + solveViaMemoization(n - 2, res);
        res[n] = i;
        return res[n];

    }

    public int solveViaTabulation(int n) {
        int first = 1;
        int second = 1;
        for (int i = 1; i < n; i++) {
            int temp = second;
            second = second + first;
            first = temp;
        }
        return second;
    }
}
