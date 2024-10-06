package com.example.demo.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://leetcode.com/problems/3sum/description/
public class ThreeSumWith2Pointers {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> total = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    total.add(List.of(nums[i], nums[l], nums[r]));
                    while(l< r && nums[l] == nums [l + 1]) {
                        l++;
                    }
                    while(l< r && nums[r] == nums [r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < -nums[i]){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return new ArrayList<>(total);
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 0 ,0 };
        threeSum(data);
    }

}
