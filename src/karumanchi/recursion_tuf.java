package karumanchi;

import java.util.ArrayList;
import java.util.Vector;

public class recursion_tuf {
    public static void main(String[] args) {
        recursion_tuf recursionTuf = new recursion_tuf();
//        System.out.println(recursionTuf.NnumbersSum(4));
//        System.out.println(recursionTuf.factorial(4));
//        System.out.println(recursionTuf.arraySum(new int[]{1, 2, 3}));
//        System.out.println(recursionTuf.palindromeCheck("madam"));
//        System.out.println(recursionTuf.checkPrime(41));
//        System.out.println(Arrays.toString(recursionTuf.reverseArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(recursionTuf.addDigits(529));
    }

    public int addDigits(int num) {
        int sum = num;
        while (sum > 10) {
            sum = addDigits(sum, 0);
        }
        return sum;

    }

    public int addDigits(int num, int sum) {
        if (String.valueOf(num).length() == 1) return num;
        sum = num%10 + addDigits(num/10, sum);
        return sum;
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        return isSorted(nums, 0);
    }

    private boolean isSorted(ArrayList<Integer> nums, int i) {
        if (i > nums.size() - 1) return true;
        if (nums.get(i) > nums.get(i + 1)) return false;
        return isSorted(nums, i + 1);
    }

    public int[] reverseArray(int[] nums) {
        return reverseArray(nums, 0);

    }

    public int[] reverseArray(int[] nums, int index) {
        if (index > nums.length / 2 - 1) return nums;

        int start = index;
        int end = nums.length - index - 1;

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        return reverseArray(nums, index + 1);

    }

    public boolean checkPrime(int num) {
        return checkPrime(num, num / 2);
    }

    public boolean checkPrime(int num, int divisor) {
        if (divisor == 1) return true;
        if (num % divisor == 0) return false;
        return checkPrime(num, divisor - 1);
    }

    public boolean palindromeCheck(String s) {
        return palindromeCheck(s.toCharArray(), 0);
    }

    public boolean palindromeCheck(char[] s, Integer index) {
        if (index > s.length / 2 - 1) return true;
        int start = index;
        int end = s.length - index - 1;

        if (s[start] != s[end]) return false;
        return palindromeCheck(s, index + 1);
    }

    public Vector<Character> reverseString(Vector<Character> s) {
        return reverseString(s, 0);
        //your code goes here
    }

    public Vector<Character> reverseString(Vector<Character> s, int index) {
        if (index > s.size() / 2 - 1) return s;
        char temp = s.get(index);
        s.set(index, s.get(s.size() - index - 1));
        s.set(s.size() - index - 1, temp);
        reverseString(s, index + 1);
        return s;
    }

    public int arraySum(int[] nums) {
        return arraySum(nums, nums.length - 1);
    }

    public int arraySum(int[] nums, int currentIndex) {
        if (currentIndex == 0) return nums[0];
        return nums[currentIndex] + arraySum(nums, currentIndex - 1);
    }

    public long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public int NnumbersSum(int N) {
        return numbersSum(N, 0);
    }

    private int numbersSum(int n, int sum) {
        if (n > 0) {
            sum += n + numbersSum(n - 1, sum);
        }
        return sum;
    }
}
