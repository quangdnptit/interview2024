package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/combination-sum-ii/description/?envType=daily-question&envId=2024-08-13
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    if (candidates[l] + candidates[r] == target) {
                        results.add(List.of(candidates[l], candidates[r], candidates[i]));
                        while (l < r && candidates[l] == candidates[l + 1]) {
                            l++;
                        }
                        while (l < r && candidates[r] == candidates[r - 1]) {
                            r++;
                        }
                        l++;
                        r--;
                    } else if (candidates[l] + candidates[r] > target - candidates[i]) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return results;
    }
}
