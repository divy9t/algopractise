package easy;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234567899));
    }

    private static boolean isPalindrome(int x) {
        int actualNumber = x;
        long reversed = 0;

        if (x <= 0)
            return false;

        while (x > 0) {
            reversed = (reversed * 10) + (x%10);
            x = x / 10;
        }

        return actualNumber == reversed;
    }


}
