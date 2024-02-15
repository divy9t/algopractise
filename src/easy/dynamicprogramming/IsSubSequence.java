package easy.dynamicprogramming;

public class IsSubSequence {
    public static void main(String[] args) {
//        System.out.println(new IsSubSequence().isSubsequence("abc", "ahbgdc"));
//        System.out.println(new IsSubSequence().isSubsequence("axc", "ahbgdc"));
        System.out.println(new IsSubSequence().isSubsequence("aaaaaa", "bbaaaa"));

    }

    private boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && !t.isBlank()) return false;
        if (!s.isEmpty() && t.isBlank()) return false;

        int p = 0;
        int q = 0;

        while (p <= q && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                if (p == s.length() - 1) return true;
                p += 1;
            }
            if (q == t.length() - 1 && s.charAt(p) != t.charAt(q) )return false;
            q += 1;
        }
        return false;

    }
    private boolean isSubsequenceOpt(String s, String t) {
        if (s.isEmpty() && !t.isBlank()) return false;
        if (!s.isEmpty() && t.isBlank()) return false;

        int p = 0;
        int q = 0;

        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                p += 1;
            }
            q += 1;
            if (p == s.length()) return true;
        }
        return false;

    }

}
