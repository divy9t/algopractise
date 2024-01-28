package easy.sortedSquare;

import java.util.Arrays;

public class AttemptTwo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-3,-2,1, 2, 3, 5, 6, 8, 9})));

    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int smallIdx = 0;
        int largeIdx = array.length - 1;
        int currentFillIndex = array.length - 1;
        while (smallIdx <= largeIdx) {
            int smallValue = array[smallIdx];
            int largeValue = array[largeIdx];

            if (Math.abs(smallValue) > Math.abs(largeValue)){
                result[currentFillIndex] = smallValue * smallValue;
                smallIdx++;
            } else {
                result[currentFillIndex] = largeValue * largeValue;
                largeIdx--;
            }
            currentFillIndex--;
        }
        return result;
    }
}
