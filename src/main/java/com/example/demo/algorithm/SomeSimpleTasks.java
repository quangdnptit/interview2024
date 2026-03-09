package com.example.demo.algorithm;

import org.apache.kafka.common.cache.LRUCache;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SomeSimpleTasks {
    String reverse(String s) {
        char[] chars = s.toCharArray();
        char[] reversed = new char[chars.length];

        int idx = 0;
        for (int j = chars.length - 1; j >= 0; j--) {
            reversed[idx] = chars[j];
            idx++;
        }

        return String.valueOf(reversed);
    }

    String reverse2Pointers(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
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


        for (Character c : chars) {
            if (charMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || charMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    List<List<String>> validAnagrams(List<String> data) {
        Map<String, List<String>> results = new HashMap<>();
        for (String s : data) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);
            List<String> group = results.get(sorted);
            if (group == null) {
                group = new ArrayList<>();
            }
            group.add(s);
            results.put(sorted, group);
        }

        return new ArrayList<>(results.values());
    }

    Character findFirstNotDuplicated(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> dataMap = new HashMap<>();
        for (Character c : chars) {
            if (dataMap.containsKey(c)) {
                return c;
            } else {
                dataMap.put(c, 1);
            }
        }

        return null;
    }

    String longestPalindrome(String s) {
        if (s == null && s.length() < 1) {
            return "";
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    public String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    int maxProfit(List<Integer> data) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (Integer price : data) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    boolean subSequenceCheck(String s1, String s2) {
        char[] subSequence1 = s1.toCharArray();
        char[] subSequence2 = s2.toCharArray();

        if (subSequence1.length > subSequence2.length) {
            return false;
        }

        int matchFound = 0;
        for (int i = 0; i < subSequence2.length; i++) {
            if (subSequence1[matchFound] == subSequence2[i]) {
                matchFound++;
            }
            if (matchFound == subSequence1.length) {
                return true;
            }
        }

        return false;
    }

    public class Request {
        private LocalDateTime time;
        private String userId;

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
    ConcurrentHashMap<String, List<Request>> concurrentHashMap = new ConcurrentHashMap<>();
    public void RateLimit(Request request) {
        LocalDateTime firstTime = request.getTime().minusMinutes(5);
        List<Request> requests = concurrentHashMap.get(request.getUserId());
        List<Request> filtered = requests.stream().filter(item -> item.getTime().isBefore(firstTime)).collect(Collectors.toList());

        if (filtered.size() >= 5) {
            //todo throw 429 exception
        } else {
            requests.add(request);
        }
    }


    public int findSecondMaxInArr(Integer[] data) {
        if(data.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(Integer i: data) {
            if(i > max) {
                secondMax = max;
                max = i;
            } else if (secondMax < i && max > i) {
                secondMax = i;
            }
        }

        return secondMax;
    }

    //todo LRU cache, merge 2 linked list, travel tree

    public static void main(String[] args) {
        SomeSimpleTasks someSimpleTasks = new SomeSimpleTasks();

//        System.out.println(someSimpleTasks.reverse2Pointers("epam"));
//        System.out.println(someSimpleTasks.validParentheses("({}{[]})"));
//        System.out.println(someSimpleTasks.findFirstNotDuplicated("acvc"));
//        System.out.println(someSimpleTasks.validAnagrams(List.of("eat","tea","tan","ate","nat","bat")));
//        System.out.println(someSimpleTasks.maxProfit(List.of(1, 6, 2, 8)));
//        System.out.println(someSimpleTasks.longestPalindrome("mirror"));
//        System.out.println(someSimpleTasks.subSequenceCheck("epam", "epamvn"));
        System.out.println(someSimpleTasks.findSecondMaxInArr(List.of(1,2,3,4,5,9,8).toArray(new Integer[0])));
    }
}
