package karumanchi.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        longestConsecutiveSequence(arr);
    }

    private static void longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> seen = new HashSet<>(100,2);
        int longestSequence = 1;


        for (int i : arr) {
            seen.add(i);
        }

        for (int i : arr) {
            // this means that it is the start of the array
           if (!seen.contains(i - 1)) {
               int currentNumber = i;
               int currentStreak = 1;

               while (seen.contains(currentNumber + 1 )) {
                   currentNumber++;
                   currentStreak++;
               }

               longestSequence = Math.max(longestSequence, currentStreak);

           }
        }
        System.out.println(longestSequence);
    }
}
