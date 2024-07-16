package com.example.demo.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> total = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>(List.of(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
            list.remove(i);
            total.addAll(twoSum(list, -nums[i]));
        }
        return new ArrayList<>(total);
    }

    public static void main(String[] args) {
        int[] data = new int[]{3,0,-2,-1,1,2};
        threeSum(data);
    }

    public static Set<List<Integer>> twoSum(List<Integer> input, int sum) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < input.size(); i++) {
            dataMap.put(sum - input.get(i), i);
        }

        for (int i = 0; i < input.size(); i++) {
            Integer val = dataMap.get(input.get(i));
            if (val != null && i != dataMap.get(input.get(i))) {
                results.add(Stream.of(-sum, input.get(i), input.get(val)).sorted().collect(Collectors.toList()));
            }
        }
        return results;
    }

}
