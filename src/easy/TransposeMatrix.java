package easy;

import java.util.*;

class TransposeMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transposeMatrix(new int[][]{{1}, {-1}})));
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposeMatrix = null;
        for (int i = 0; i < matrix.length; i++) {
            if (Objects.isNull(transposeMatrix))
                transposeMatrix = new int[matrix[i].length][matrix.length];
            for (int j = 0; j < matrix[i].length; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
}
