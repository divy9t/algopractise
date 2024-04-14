package karumanchi.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(getLongestSubString("pwwkew"));
    }

    private static String getLongestSubString(String string) {
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
        return longestString;
    }
}
