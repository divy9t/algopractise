package karumanchi;

import java.util.*;

public class string_tuf {
    public static void main(String[] args) {
        string_tuf stringTuf = new string_tuf();
        stringTuf.reverseString(new Vector<Character>(Arrays.asList('h', 'e', 'l', 'l', 'o')));
        System.out.println(stringTuf.longestCommonPrefix(new String[]{"flowers", "flow", "fly", "flight"}));
        System.out.println(stringTuf.largeOddNum("0032579"));
        System.out.println(stringTuf.largeOddNum("palindromeCheck"));
        System.out.println(stringTuf.isomorphicString("egg","add"));
        System.out.println(stringTuf.rotateString("abcde","cdeab"));
        System.out.println(stringTuf.anagramStrings("anagram","nagaram"));
        System.out.println(stringTuf.frequencySort("tree"));

    }

    public int NnumbersSum(int N) {

    }

    public List<Character> frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();

        for (Character character : s.toCharArray()) {
            counter.put(character, counter.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
                this::getPriorityOrder
        );

        priorityQueue.addAll(counter.entrySet());

        List<Character> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().getKey());
        }
        return result;

    }

    private int getPriorityOrder(Map.Entry<Character, Integer> p, Map.Entry<Character, Integer> q) {
        int i = q.getValue().compareTo(p.getValue());
        if (i != 0)
            return i;
        return p.getKey() - q.getKey();
    }

    public void reverseString(Vector<Character> s) {

        for (int i = 0; i < s.size() / 2; i++) {
            int lastElement = s.size() - 1 - i;

            Character temp = s.get(i);
            s.set(i, s.get(lastElement));
            s.set(lastElement, temp);
            System.out.println(s);
        }
        System.out.println(s);
    }

    public boolean palindromeCheck(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1])
                return false;
        }
        return true;
    }

    public String largeOddNum(String s) {
        char[] charArray = s.toCharArray();

        int startIndex = 0;
        while (charArray[startIndex] == '0') {
            startIndex++;
        }
        int endIndex = startIndex;

        for (int i = startIndex + 1; i < charArray.length; i++) {
            if (charArray[i] % 2 != 0)
                endIndex = i;
        }

        return s.substring(startIndex, ++endIndex);
    }

    public String longestCommonPrefix(String[] str) {
        StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        Character currentChar = null;
        int smallest = Integer.MAX_VALUE;

        for (String s : str) {
            if (smallest > s.length()) smallest = s.length();
        }

        while (currentIndex <= smallest - 1) {
            for (String s : str) {
                if (Objects.isNull(currentChar))
                    currentChar = s.charAt(currentIndex);
                if (currentChar != s.charAt(currentIndex))
                    return result.toString();

            }
            if (currentChar != null) result.append(currentChar);
            currentChar = null;
            currentIndex++;
        }
        return result.toString();

    }

    public boolean isomorphicString(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }


        return true;

    }

    public boolean anagramStrings(String s, String t) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        s = new String(charArray);

        charArray = t.toCharArray();
        Arrays.sort(charArray);
        t = new String(charArray);

        return s.equals(t);

    }

    public boolean rotateString(String s, String goal) {
        int count = s.length();

        while (count > 0) {
            s = rotateStringByOne(s);
            if (s.equals(goal)) return true;
            count--;
        }

        return false;
    }

    private String rotateStringByOne(String s) {
        char[] charArray = s.toCharArray();
        char first = charArray[0];

        for (int i = 0; i < s.length() - 1; i++) {
            charArray[i] = charArray[i + 1];
        }
        charArray[charArray.length - 1] = first;
        return new String(charArray);

    }
}
