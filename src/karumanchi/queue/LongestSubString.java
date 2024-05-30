package karumanchi.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(getLongestSubString("c"));
    }

    private static int getLongestSubString(String string) {
        if (string.isEmpty()) return 0;
        if (string.trim().isEmpty()) return 1;
        Queue<Character> queue = new LinkedList<>();
        String longestString = "";

        for (Character c : string.toCharArray()) {
            if (queue.contains(c)) {
                StringBuilder tempString = new StringBuilder();
                while (!queue.isEmpty())
                    tempString.append(queue.remove());
                if (longestString.length() < tempString.length())
                    longestString = tempString.toString();
            }
            queue.add(c);
        }
        if (!queue.isEmpty()) {
            StringBuilder tempString = new StringBuilder();
            while (!queue.isEmpty())
                tempString.append(queue.remove());
            if (longestString.length() < tempString.length())
                longestString = tempString.toString();
        }

        return longestString.length();
    }
}
