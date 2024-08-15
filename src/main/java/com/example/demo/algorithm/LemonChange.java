package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LemonChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                ten++;
                five--;
                if (five < 0) {
                    return false;
                }
            } else {
                twenty++;
                if (ten > 0) {
                    if (five < 1) {
                        return false;
                    }
                    ten--;
                    five--;
                } else {
                    if (five < 3) {
                        return false;
                    }
                    five = five - 3;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(in));
    }
}
