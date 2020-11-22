package com.elmer.leetcode.offer;

public class Solution44 {
    public int findNthDigit(int n) {
        // 1 求在哪个区间
        int digit = 1, start = 1, count = 9;
        while (count < n) {
            n -= count;
            start *= 10;
            digit++;
            count = 9 * digit * start;

        }
        // 2 求是哪个数
        long num = (n - 1) / digit + start;  // 减1是因为从0开始
        // 3 num的哪个位
        int b = (n - 1) % digit;
        return Long.toString(num).charAt(b) - '0';
    }
}
