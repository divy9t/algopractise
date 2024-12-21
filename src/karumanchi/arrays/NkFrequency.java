package karumanchi.arrays;

import java.util.*;

public class NkFrequency {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        findFrequency(arr, 4);

    }

    private static void findFrequency(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else if (map.get(num) < (k -1 )) {
                map.put(num, map.get(num) + 1);
            } else {
                Iterator<Integer> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    if (map.get(num) == 1) {
                        iterator.remove();
                    } else {
                        map.put(num, map.get(num) - 1);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (arr.length/k)) {
                result.add(entry.getKey());
            }
        }

        System.out.println(result.toString());
    }
}