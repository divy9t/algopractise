package karumanchi.arrays;

import java.util.HashMap;

public class CheckArraySubset {
    public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3}, b = {11, 3, 7, 1, 7};

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : b) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }

        for (int num : a) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.getOrDefault(num, 1) - 1);
                if (countMap.get(num) == 0) {
                    countMap.remove(num);
                }
            }

        }

        if (countMap.isEmpty())
            System.out.println("Yes this is true");
    }
}
