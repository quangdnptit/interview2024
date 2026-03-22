package com.example.demo.algorithm;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longest= "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(i, i, s);
            String even = expand(i, i + 1, s);

            if(odd.length() >= longest.length()) {
                longest = odd;
            }

            if(even.length() >= longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    public String expand(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
