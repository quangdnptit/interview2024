package com.example.demo;

//https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
public class PatternOfLengthMRepeatedKOrMore {

    //phần tử phải giống phần tử cách nó m vị trí

    // m la block length, k la so lan can match
    public boolean containsPattern(int[] arr, int m, int k) {
        int total = 0;
        for (int i = 0; i < arr.length - m; i++) {
            if (arr[i] == arr[i + m]) {
                total++;
                //cần match thêm k-1 block
                if (total == (k - 1) * m) {
                    return true;
                }
            } else {
                total = 0;
            }
        }

        return total >= k;
    }

    public static void main(String[] args) {

    }
}
