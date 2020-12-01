package com.elmer.leetcode.offer;

public class Solution65 {

//     递归
//    public int add(int a, int b) {
//        if (b == 0) return a;
//        return add(a ^ b, (a & b) << 1);
//    }
    // 非递归
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
