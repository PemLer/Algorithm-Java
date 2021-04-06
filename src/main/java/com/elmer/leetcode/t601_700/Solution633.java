package com.elmer.leetcode.t601_700;

public class Solution633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c) + 1, total;
        while (left <= right) {
            total = left * left + right * right;
            if (total == c) {
                return true;
            } else if (total < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
