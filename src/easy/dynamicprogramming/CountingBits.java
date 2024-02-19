package easy.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingBits {

    public static void main(String[] args) {
        new CountingBits().countBits(31);
    }

    public int[] countBits(int n) {
        if (n <= 0)
            return new int[]{0};
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i  <= n ; i++) {
            if (i <= 10)
                result[i] = (int) Integer.toBinaryString(i).chars().filter(j -> j == '1').count();
            result[i] = result[i % 2] + result[i / 2];

        }
        printArray(result);
        return result;
    }
    public void printArray(int[] result) {

        System.out.println("Index: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(i + "\t");
        }

        System.out.println("\nValues:");
        for (int value : result) {
            System.out.print(value + "\t");
        }
    }

}
