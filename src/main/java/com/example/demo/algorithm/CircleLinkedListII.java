package com.example.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

public class CircleLinkedListII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
            }

            temp = temp.next;
        }
        return null;
    }
}
