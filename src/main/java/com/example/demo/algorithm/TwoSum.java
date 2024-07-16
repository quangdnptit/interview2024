package com.example.demo.algorithm;

import java.util.*;

//given array of int, return indices of array that add up to target
public class TwoSum {
    public static void main(String[] args) {
        twoSum(new int[]{3,2,4}, 6);
    }

    public static int[] twoSum(int[] input, int sum) {
        Map<Integer, Integer> dataMap = new HashMap<>();

        for (int i =0; i< input.length; i++) {
            dataMap.put(sum - input[i], i);
        }
        for (int i =0; i< input.length; i++) {
            Integer val = dataMap.get(input[i]);
            if (val != null && val != i) {
                return new int[]{i, val};
            }
        }
        return new int[]{};
    }
}
