package easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)));


    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashMap<Integer, Boolean> resultHash = new HashMap<>();
        for (int i : array){
            if (targetSum == 1)
                return new int[]{i, 0};
            int diff = targetSum - i;
            if (resultHash.containsKey(diff))
                return new int[]{diff, i};
            resultHash.put(i, true);
        }
        return new int[]{};
    }
}