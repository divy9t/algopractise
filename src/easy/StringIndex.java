package easy;

public class StringIndex {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
    public static int strStr(String haystack, String needle) {
        int lead = needle.length();
        int trail = 0;

        while (lead <= haystack.length()) {
            if (haystack.substring(trail, lead).equalsIgnoreCase(needle))
                return trail;

            lead += 1;
            trail+= 1;
        }
        return -1;
    }
}
