package karumanchi.arrays;

public class CheckIfArrayElementsArePalindrome {
    public static void main(String[] args) {
       int[] arr = {111, 222, 333, 444, 555};

       peformLogica(arr);
    }

    private static void peformLogica(int[] arr) {
        for (int num : arr) {
            if (Integer.reverse(num) != num)
                System.out.println("No Palindrome");
        }
    }
}
