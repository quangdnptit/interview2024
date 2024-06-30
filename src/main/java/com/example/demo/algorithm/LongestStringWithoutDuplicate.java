package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringWithoutDuplicate {
    public static void main(String[] args) {
        String input = "pwwkew";
        if (input.length() == 0) {
            System.out.println(0);
        }
        Map<String, List<Integer>> dataMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (dataMap.get(input.charAt(i) + "") == null) {
                dataMap.put(input.charAt(i) + "", List.of(i));
            } else {
                List<Integer> newVal = dataMap.get(input.charAt(i) + "");
                newVal.add(i);
                dataMap.put(input.charAt(i) + "", newVal);
            }
        }
        int max = 0;
        for (Map.Entry<String, List<Integer>> entry : dataMap.entrySet()) {
            List<Integer> indices = entry.getValue();
            if (indices.size() == 2) {
                max = indices.get(1)- indices.get(0);
            }
        }

    }
}
