package easy;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    private static int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }
    private static int climbStairs(int i, HashMap<Integer, Integer> mem) {
        if (mem.containsKey(i)) return mem.get(i);
        if (i <= 2) return i;
        mem.putIfAbsent(i, climbStairs(i - 1, mem) + climbStairs(i - 2, mem));
        return mem.get(i);
    }


}
