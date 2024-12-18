package karumanchi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargeNumberFactorial {
    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 2; i <=100; i++) {
            int carry = 0;

            for (int j = 0; j  < result.size(); j++) {
                int product = i * result.get(j) + carry;
                result.set(j, product%10);
                carry = product / 10;

            }

            while (carry > 0) {
                result.add(carry%10);
                carry /= 10;

            }
        }
        Collections.reverse(result);

        System.out.println("Factorial of 100 is: " + result);

    }
}
