package easy.sortedSquare;

import java.util.Arrays;

public class AttemptOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-3,-2,1, 2, 3, 5, 6, 8, 9})));

    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];

        for (int i=0; i < array.length; i++){
            result[i] = array[i] * array[i];
        }

        return bubbleSort(result);

    }

    private static int[] bubbleSort(int[] result) {
        int n = result.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }
        return result;
    }

}
