package com.example.demo.algorithm;

//https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-10-07
public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        String regex = "(?:AB|CD)";
        int originalLength = s.length();
        int newLength = 0;
        while (newLength < originalLength) {
            originalLength = s.length();
            s = s.replaceAll(regex, "");
            newLength = s.length();
        }
        return s.length();
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings s = new MinimumStringLengthAfterRemovingSubstrings();
        s.minLength("ABFCACDB");
    }
}
