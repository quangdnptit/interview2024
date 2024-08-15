package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

public class OptimizedFibonacy {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 2);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }

        return map.get(n);
    }
}
