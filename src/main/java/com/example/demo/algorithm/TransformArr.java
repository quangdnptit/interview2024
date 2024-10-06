package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/rank-transform-of-an-array/?envType=daily-question&envId=2024-10-02
public class TransformArr {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = new int[arr.length];
        int[] idx = new int[arr.length];
        System.arraycopy(arr, 0, clone, 0, arr.length);

        Arrays.sort(arr);
        Map<Integer, Integer> data = new HashMap();

        //thuc ra cai rank no deo lien quan den cai order lam, lam bien tam mak e life ez
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!data.containsKey(arr[i])) {
                data.put(arr[i], rank);
            }
            rank++;
        }

        for (int i = 0; i < clone.length; i++) {
            idx[i] = data.get(clone[i]);
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] a = new int[]{40, 40, 40, 40};
        TransformArr transformArr = new TransformArr();
        transformArr.arrayRankTransform(a);
    }
}
