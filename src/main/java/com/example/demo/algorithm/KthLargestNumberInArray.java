package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestNumberInArray {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
