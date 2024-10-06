package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int targetIdx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= targetIdx) {
                targetIdx = i;
            }
            if (targetIdx == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 1, 4};
        JumpGame s = new JumpGame();
        s.canJump(a);
    }
}
