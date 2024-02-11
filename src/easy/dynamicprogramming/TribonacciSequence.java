package easy.dynamicprogramming;

import java.util.HashMap;

public class TribonacciSequence {
    public static void main(String[] args) {
        System.out.println(tribonacci(35));
    }

    private static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }
    private static int tribonacci(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 0) return 0;
        if (n <= 2) return 1;
        map.put(n, tribonacci(n - 1, map) + tribonacci(n - 2, map) + tribonacci(n - 3, map));
        return map.get(n);
    }
}
