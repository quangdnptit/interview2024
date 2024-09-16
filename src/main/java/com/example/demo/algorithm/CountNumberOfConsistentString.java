package com.example.demo.algorithm;

import java.util.*;

// https://leetcode.com/problems/count-the-number-of-consistent-strings/description/?envType=daily-question&envId=2024-09-12
public class CountNumberOfConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {
        char[] sorted = allowed.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : sorted) {
            map.put(c, true);
        }

        int count = 0;
        boolean valid = true;
        for (String sortedWord : words) {
            for (int i = 0; i < sortedWord.length(); i++) {
                if (map.get(sortedWord.charAt(i)) == null) {
                    valid = false;
                    break;
                }
                if (map.get(sortedWord.charAt(i)) == null) {
                    continue;
                }
                if (!map.get(sortedWord.charAt(i))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count ++;
            }
            valid = true;
        }
        return count;
    }

    public static void main(String[] args) {
        CountNumberOfConsistentString countNumberOfConsistentString = new CountNumberOfConsistentString();
        String[] abc = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(countNumberOfConsistentString.countConsistentStrings("abc", abc));
    }
}
