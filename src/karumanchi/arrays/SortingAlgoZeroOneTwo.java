package karumanchi.arrays;

import java.util.Arrays;

public class SortingAlgoZeroOneTwo {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid<=high) {
           switch (arr[mid]) {
               case 0:
                   int temp = arr[mid];
                   arr[mid] = arr[low];
                   arr[low] = temp;
                   mid++;
                   low++;
                   break;

               case 1:
                   mid++;
                   break;

               case 2:
                   int t = arr[mid];
                   arr[mid] = arr[high];
                   arr[high] = t;
                   high--;
                   break;

           }
        }
    }
}
