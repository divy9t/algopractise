package karumanchi;

import java.util.*;

public class map_tuf {
    public static void main(String[] args) {
        System.out.println(new map_tuf().sumHighestAndLowestFrequency(new int[]{10, 9, 7, 7, 8, 8, 8}));
    }

    public int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> counter = new TreeMap<>();

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        TreeMap<Integer, Integer> valueCompare = getIntegerIntegerTreeMap(counter);
        System.out.println(valueCompare);

        int currentCount = 0;

        for (Map.Entry<Integer, Integer> map : valueCompare.entrySet()) {
            if (currentCount++ == 2) {
                return valueCompare.get(map.getKey());
            }
            currentCount++;
        }

        return -1;

    }

    private static TreeMap<Integer, Integer> getIntegerIntegerTreeMap(Map<Integer, Integer> counter) {
        TreeMap<Integer, Integer> valueCompare = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (valueCompare.containsKey(entry.getValue())) {
                Integer current = valueCompare.get(entry.getValue());
                if (current > entry.getKey())
                    valueCompare.put(entry.getValue(), entry.getKey());

            } else {
                valueCompare.put(entry.getValue(), entry.getKey());
            }
        }
        return valueCompare;
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> counter = new TreeMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            treeMap.put(entry.getValue(), entry.getKey());
        }

        return treeMap.firstKey() + treeMap.lastKey();


    }



}


