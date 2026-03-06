package com.example.demo.algorithm;


public class EPAMSubSequenceCheck {
    public Boolean subSequenceCheck(String s1, String s2) {
        char[] totalChar = s2.toCharArray();
        char[] subsequenceChar = s1.toCharArray();
        if (totalChar.length < subsequenceChar.length) {
            return false;
        }

        int idx = 0;

        for(int i =0; i< totalChar.length; i++) {
            if(totalChar[i] == subsequenceChar[idx]) {
                idx ++;
            }
            if(idx == subsequenceChar.length){
                return true;
            }
        }


        return false;
    }



    public static void main(String[] args) {

        //tim kiem du so phan tu trong str1, co nam o trong st2 hay k
      //  "DSA: Given 2 strings, str1 = ""epvi"" and str2 = ""epamvietnam"", how can we detect str1 is subsequence of str2. In the example, str1 is subsequence of str2 because if we remove some chars of str2, we will get str1"
        EPAMSubSequenceCheck epamSubSequenceCheck = new EPAMSubSequenceCheck();
        System.out.println(epamSubSequenceCheck.subSequenceCheck("epmvitnn","epamvietnam"));


    }
}
