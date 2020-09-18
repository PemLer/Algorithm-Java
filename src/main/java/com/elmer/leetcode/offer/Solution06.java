package com.elmer.leetcode.offer;

import com.elmer.leetcode.common.ListNode;

public class Solution06 {

    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode first = head;
        while (head != null) {
            head = head.next;
            count++;
        }
        int[] res = new int[count];
        int i = count - 1;
        while (first != null) {
            res[i] = first.val;
            i--;
            first = first.next;
        }
        return res;
    }
}
