package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GFTInterview {
    public int totalRepeatedSequence(String s, String word) {
        int total = 0;
        String repeated = word;
        while (s.contains(repeated)) {
            total++;
            repeated = repeated + word;
        }
        return total;
    }

    public static void main(String[] args) {
        GFTInterview gftInterview = new GFTInterview();
        System.out.println(gftInterview.totalRepeatedSequence("abaaabab", "ab"));
    }
}
