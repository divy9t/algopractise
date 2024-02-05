package easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
