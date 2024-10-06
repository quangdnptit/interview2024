package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/?envType=daily-question&envId=2024-10-01
public class ArrayPairDivisibleByK {

    public boolean canArrange(int[] arr, int k) {

        if (arr.length % 2 == 1) {
            return false;
        }
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            if (remainderFreq.containsKey(remainder)) {
                remainderFreq.put(remainder , remainderFreq.get(remainder) + 1);
            } else  {
                remainderFreq.put(remainder , 1);
            }
        }

        if (remainderFreq.get(0) % 2 != 0) {
            return false;
        }

        for (int i = 1; i < k; i++) {
            if (remainderFreq.get(i) != remainderFreq.get(k - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayPairDivisibleByK arrayPairDivisibleByK = new ArrayPairDivisibleByK();
        int[] a = new int[]{-4, -7, 5, 2, 9, 1, 10, 4, -8, -3};
        arrayPairDivisibleByK.canArrange(a, 3);
    }
}
