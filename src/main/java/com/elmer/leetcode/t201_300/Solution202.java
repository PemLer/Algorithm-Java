package com.elmer.leetcode.t201_300;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {

    // 方法一 HashSet
//    public boolean isHappy(int n) {
//        Set<Integer> record = new HashSet<>();
//        while (n != 1 && !record.contains(n)) {
//            record.add(n);
//            n = getNext(n);
//        }
//        return n == 1;
//    }

    // 方法二 链表环检测
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int v = n % 10;
            n /= 10;
            res += v * v;
        }
        return res;
    }
}
