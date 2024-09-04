package com.example.demo.algorithm;

//https://leetcode.com/problems/number-complement/description/?envType=daily-question&envId=2024-08-22
public class NumberComplement {
    public static int findComplement(int num) {
        int numOfBinary = 0;
        int temp = num;
        while(temp > 0) {
            temp = temp/2;
            numOfBinary ++;
        }

        int max= 0;
        for(int i=0; i<numOfBinary; i++) {
            max = (int) (max + Math.pow(2, i));
        }
        return max - num;
    }

    public static void main(String[] args) {
         findComplement(3);
    }
}
