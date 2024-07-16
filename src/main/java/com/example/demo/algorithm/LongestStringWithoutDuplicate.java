package com.example.demo.algorithm;

import java.util.*;

public class LongestStringWithoutDuplicate {
    public static void main(String[] args) {
        String input = "pwwkew";
        if (input.length() == 0) {
            System.out.println(0);
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < input.length()) {
            Character rightValue = input.charAt(right);
            if (map.containsKey(rightValue)) {
                left = Math.max(map.get(rightValue) + 1, left);
            }
            max = Math.max(max, right - left + 1);
            map.put(rightValue, right);
            right++;
        }
        System.out.println("result" + max);
    }
}
