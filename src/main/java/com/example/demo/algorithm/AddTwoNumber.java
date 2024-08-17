package com.example.demo.algorithm;

//https://leetcode.com/problems/add-two-numbers/description/
// Definition for singly-linked list


import lombok.val;

import java.util.List;

public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode curr = sum;
        boolean shouldBuffer = false;

        while (l1 != null || l2 != null || shouldBuffer) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            int curVal = val + (shouldBuffer ? 1 : 0);
            if (curVal >= 10) {
                shouldBuffer = true;
                val = curVal % 10;
            } else {
                val = curVal;
                shouldBuffer = false;
            }

            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return sum.next;
    }

    public static int getVal(ListNode l1) {
        if (l1 == null) {
            return 0;
        }
        return l1.val;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6, new ListNode(4));

        addTwoNumbers(listNode1, listNode2);
    }
}
