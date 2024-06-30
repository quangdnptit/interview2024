package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//given array of int, return indices of array that add up to target
public class TwoSum {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 9;
        Map<Integer, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            dataMap.put(sum - input.get(i), i);
        }
        for (int i = 0; i < input.size(); i++) {
            if (dataMap.get(input.get(i)) != null) {
                System.out.println("indices found: " + dataMap.get(input.get(i)) + "," + i);
                break;
            }
        }
    }
}
