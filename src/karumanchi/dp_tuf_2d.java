package karumanchi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class dp_tuf_2d {
    public static void main(String[] args) {
        dp_tuf_2d dpTuf2d = new dp_tuf_2d();
        System.out.println(dpTuf2d.minFallingPathSum(
            new int[][]{
                {4, 3, 4},
                {4, 5, 1},
                {4, 6, 2},
                {4, 1, 4} }
            )
        );
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int matrixLength = matrix.length - 1;
        int[][] dp = new int[matrixLength + 1][matrix[matrixLength].length];


        int result = Integer.MAX_VALUE;
        for (int itr = 0; itr < matrix[matrixLength].length; itr++) {
            int res = solveMinFallingPathSum(matrix, matrixLength, itr, dp);
            result = Math.min(result, res);
        }
        return result;
    }

    public int solveMinFallingPathSum(int[][] matrix, int row, int col, int[][] dp) {
        if (row == -1 || col == -1) return 0;
        if (dp[row][col] != 0) return dp[row][col];
        int top =  solveMinFallingPathSum(matrix, row - 1, col , dp) + matrix[row][col];
        int topRight = Integer.MAX_VALUE;
        if (col > 0)
            topRight = solveMinFallingPathSum(matrix, row - 1, col - 1, dp) + matrix[row][col];
        int topLeft = Integer.MAX_VALUE;
        if (col < matrix[row].length - 1)
            topLeft = solveMinFallingPathSum(matrix, row - 1, col + 1, dp) + matrix[row][col];

        int result = Math.min(top, Math.min(topRight, topLeft));
        dp[row][col] = result;
        return result;

    }

    public int uniquePathsWithObstacles(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();
        return solveUniquePathsWithObstacles(matrix, map, matrix.length - 1, matrix[0].length - 1);

    }

    public int solveUniquePathsWithObstacles(int[][] matrix, HashMap<String, Integer> map, int row, int col) {
        String key = row + "_" + col;
        if (row == -1 || col == -1) return 0;
        if (matrix[row][col] == 1) return 0;
        if (row == 0 && col == 0) return 1;

        if (map.getOrDefault(key, null) != null) return map.get(key);

        int left = solveUniquePathsWithObstacles(matrix, map, row - 1, col);
        int up = solveUniquePathsWithObstacles(matrix, map, row, col - 1);

        int sol = left + up;
        map.put(key, sol);
        return sol;
    }

}
