package karumanchi.arrays;

import java.util.Arrays;

public class FindTripletSum {
    public static void main(String[] args) {
        int[] input = {1, 4, 45, 6, 10, 8};
        int target = 13;
        boolean found = false;


        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
           int find = target - input[i];

           int p = i + 1, q = input.length - 1;

           while (p < q) {
               int tempSum = input[p] + input[q];
               if (tempSum > find) {
                   q--;
               } else if (tempSum < find) {
                   p++;
               } else {
                   System.out.println("Found the triplet " + input[i] + " " + input[p] + " " + input[q] );
                   found = true;
                   break;
               }
           }

        }

        if (!found)
            System.out.println("No match exists");

    }
}
