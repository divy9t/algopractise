package karumanchi.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class TotalSumZeroSubArray {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, -2, -1};
        findTotalSumZeroSubArray(arr);
    }

    private static void findTotalSumZeroSubArray(int[] arr) {
        int prefixSum = 0;
        HashMap<Integer, Integer> seenSet = new HashMap<>();

        for (int i=0 ; i < arr.length;i++) {
            prefixSum += arr[i];

            if (prefixSum == 0 ) {
                System.out.println("Range from " + arr[0] + " to " + arr[i]);
                break;
            }

            if (seenSet.containsKey(prefixSum)) {
                System.out.println("Range from " + arr[seenSet.get(prefixSum)] + " to " + arr[i]);
                break;

            }

            seenSet.put(prefixSum, i);
        }
    }

}

