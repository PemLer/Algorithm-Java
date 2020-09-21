package com.elmer.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;
    public  ListNode(int x) { val = x; }

    public static ListNode creatListNode() {
        int[] nums = new int[]{1,2,3,4,5};
        return ListNode.creatListNode(nums);
    }

    public static ListNode creatListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static String toArrayList(ListNode node) {
        List<Integer> res = new ArrayList<>();
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res.toString();
    }

}
