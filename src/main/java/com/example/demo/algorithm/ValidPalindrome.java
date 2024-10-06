package com.example.demo.algorithm;

//https://leetcode.com/problems/longest-palindromic-substring/description/
public class ValidPalindrome {
    public boolean isPalindrome(String str) {
        String result = str.replaceAll("[^a-zA-Z0-9]", "");
        int l = 0;
        int r = result.length() - 1;
        while (l < r) {
            if (Character.toLowerCase(result.charAt(l)) == Character.toLowerCase(result.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome l = new ValidPalindrome();
        l.isPalindrome("0P");
    }
}
