package com.elmer.leetcode.t001_100;

public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int low = 0, high = x / 2, mid;
        while (low < high) {
            mid = low + (high - low + 1) / 2;
            if (mid > x / mid) {  // 避免 mid * mid 导致 int 越界
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }
}
