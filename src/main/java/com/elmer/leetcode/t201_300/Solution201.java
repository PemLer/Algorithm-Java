package com.elmer.leetcode.t201_300;

public class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        // 寻找起点和终点的公共前缀
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
