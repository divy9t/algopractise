package karumanchi.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindIntegersWhoseSumEqualToNumber {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        findIntegersWhoseSumEqualToNumber(arr, 6);
    }

    private static void findIntegersWhoseSumEqualToNumber(int[] arr, int sum) {
        HashSet<Integer> seen = new HashSet<>();

        for (int j : arr) {
            int complement = sum - j;
            if (seen.contains(complement)) {
                System.out.println("The pair is: " + complement + " , " + j);
            } else {
                seen.add(j);
            }
        }

    }
}
