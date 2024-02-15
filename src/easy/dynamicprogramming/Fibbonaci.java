package easy.dynamicprogramming;

import java.util.HashMap;

public class Fibbonaci {
    public static void main(String[] args) {
        System.out.println(new Fibbonaci().fib(4));
        System.out.println(new Fibbonaci().fib(5));
        System.out.println(new Fibbonaci().fib(62329));
    }

    public int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public int fib(int n, HashMap<Integer, Integer> hashMap) {
        if (hashMap.containsKey(n)) return hashMap.get(n);
        if (n <= 1)  return n;
        hashMap.put(n, fib(n-1, hashMap) + fib(n-2, hashMap));
        return hashMap.get(n);
    }
}
