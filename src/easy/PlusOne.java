package easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
    }

    /*
     * You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer.
     *
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     */
    public static int[] plusOne(int[] digits) {
        int carry = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (i == digits.length - 1)
                sum = sum + 1;
            carry = sum / 10;
            digits[i] = sum % 10;
        }

        if (carry != 0) {
            int[] newArray = new int[digits.length + 1];
            for ( int i = 0 ; i < newArray.length - 1; i++) {
                if (carry != 0) {
                    newArray[i] = carry;
                    carry = 0;
                } else
                    newArray[i] = digits[i];
            }
            return newArray;

        }


        return digits;
    }
}
