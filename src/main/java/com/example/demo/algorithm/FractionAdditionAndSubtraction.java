package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//https://leetcode.com/problems/fraction-addition-and-subtraction/description/?envType=daily-question&envId=2024-08-23
public class FractionAdditionAndSubtraction {
    public static String fractionAddition(String expression) {
        String result = "";
        String[] nums = expression.split("/|(?=[-+])");
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            result = sum(result, nums[i], nums[i + 1]);
        }
        return result;
    }

    public static String sum(String sum, String st2, String sm2) {
        int t1 = 0;
        int t2 = Integer.parseInt(st2);
        int m1 = 0;
        int m2 = Integer.parseInt(sm2);

        if (sum.equalsIgnoreCase("")) {
            t1 = 0;
            m1 = 1;
        } else {
            String[] sums = sum.split("/");
            t1 = Integer.parseInt(sums[0]);
            m1 = Integer.parseInt(sums[1]);
        }

        int sumM = m1 * m2;
        int sumT = t1 * m2 + t2 * m1;

        int a = sumT;
        int b = sumM;
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }

        sumT /= b;
        sumM /= b;


        return sumT > 0 && sumM > 0 || sumT < 0 && sumM < 0 ? Math.abs(sumT) + "/" + Math.abs(sumM) : -Math.abs(sumT) + "/" + Math.abs(sumM);
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("1/3-1/2"));
    }
}
