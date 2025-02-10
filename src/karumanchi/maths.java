package karumanchi;

import java.util.*;
import java.util.function.Predicate;

public class maths {
    public static void main(String[] args) {

        System.out.println(new maths().LCM(4, 12));

    }

    public int[] divisors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) result.add(i);
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public int LCM(int n1, int n2) {
        for (int i = Math.min(n1, n2); i <= Math.pow(Math.max(n1, n2), 2); i++) {
            if (i % n1 == 0 && i % n2 == 0) return i;
        }
        return 0;

    }

    public int GCD(int n1, int n2) {
        Set<Integer> divisorOfOne = new HashSet<>();
        divisorOfOne.add(n1);
        Set<Integer> divisorOfTwo = new HashSet<>();
        divisorOfTwo.add(n2);

        for (int i = 1; i <= n1/2; i++) {
            if (n1 % i == 0) divisorOfOne.add(i);
        }
        for (int i = 1; i <= n2/2; i++) {
            if (n2 % i == 0) divisorOfTwo.add(i);
        }

        divisorOfTwo.retainAll(divisorOfOne);

        int highest = Integer.MIN_VALUE;

        for (int c : divisorOfTwo) {
            if (highest < c) highest = c;
        }
        return highest;
    }

    public int primeUptoN(int n) {
        int count = 0;

        while (n > 0) {
            if (isPrime(n--)) count++;
        }
        return count;

    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean isPerfect(int n) {
        int result = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) result += i;
        }

        return result == n;
    }

    public boolean isArmstrong(int n) {
        String nums = String.valueOf(n);
        int pow = nums.length();

        int finalNumber = 0;

        while (n > 0) {
            int temp = n % 10;
            finalNumber += (int) Math.pow(temp, pow);
            n = n / 10;
        }

        return finalNumber == Integer.parseInt(nums);

    }

    public int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    public int largestDigit(int n) {

        int largest = Integer.MIN_VALUE;

        while (n > 0) {
            int i = n % 10;
            if (largest < i) largest = i;
            n = n / 10;
        }

        return largest;
    }

    public boolean isPalindrome(int n) {
        int val = n;
        if (n == 0)
            return true;
        StringBuilder halfNum = null;
        while (val > 0) {

            if (halfNum == null)
                halfNum = new StringBuilder(String.valueOf(val % 10));
            else
                halfNum.append(val % 10);

            if (halfNum.toString().equals(Integer.toString(val)))
                return true;

            val = val / 10;
            if (halfNum.toString().equals(Integer.toString(val)))
                return true;
        }
        return false;
    }


    public int reverseNumber(int n) {
        String value = String.valueOf(n);
        StringBuilder result = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            result.append(value.charAt(i));
        }
        return Integer.parseInt(result.toString());
    }
}
