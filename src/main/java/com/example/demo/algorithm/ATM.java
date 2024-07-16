package com.example.demo.algorithm;

public class ATM {
    public static void main(String[] args) {
        cal(13000);
    }

    public static String cal(int sum) {
        int noOf2k = 5;
        int noOf200 = 10;
        int noOf500 = 10;
        int noOf100 = 10;

        if (sum > 5 * 2000 + 10 * 500 + 10 * 200 + 10 * 100) {
            return "can't withdraw";
        }

        int available = numOfMoney(sum, 5, 2000);
         available = numOfMoney(available, 10, 500);
         available = numOfMoney(available, 10, 200);
         available = numOfMoney(available, 10, 100);

        return "done";
    }

    public static int numOfMoney(int remaining, int available, int val) {
        if (remaining / val < available) {
            System.out.println("Number of needed " + val + "is " + remaining / val);
            return remaining - (remaining / val) * val;
        }
        System.out.println("Number of needed " + val + "is " + available);
        return remaining - available * val;
    }
}
