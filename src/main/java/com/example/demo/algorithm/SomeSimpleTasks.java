package com.example.demo.algorithm;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SomeSimpleTasks {
    String reverse(String s) {
        char[] chars = s.toCharArray();
        char[] reversed = new char[chars.length];

        int idx = 0;
        for(int j = chars.length - 1; j >= 0; j--) {
            reversed[idx] = chars[j];
            idx ++;
        }

        return String.valueOf(reversed);
    }

    String reverse2Pointers(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while(left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left ++;
            right --;
        }

        return String.valueOf(chars);
    }

    boolean validParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('{', '}');
        charMap.put('[', ']');
        charMap.put('(', ')');


        for(Character c : chars) {
            if (charMap.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || charMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    Character findFirstNotDuplicated(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> dataMap = new HashMap<>();
        for(Character c : chars) {
            if(dataMap.containsKey(c)) {
                return c;
            } else {
                dataMap.put(c, 1);
            }
        }

        return null;
    }

    //todo LRU cache, merge 2 linked list, travel tree

    public static void main(String[] args) {
        SomeSimpleTasks someSimpleTasks = new SomeSimpleTasks();

//        System.out.println(someSimpleTasks.reverse2Pointers("epam"));
//        System.out.println(someSimpleTasks.validParentheses("({}{[]})"));
        System.out.println(someSimpleTasks.findFirstNotDuplicated("acvc"));
    }
}
