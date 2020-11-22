package com.elmer.leetcode.offer;

public class Solution46 {
    public int translateNum(int num) {
        int n = String.valueOf(num).length();
        int[] nums = new int[n];
        int i = n - 1;
        while (num != 0) {
            nums[i] = num % 10;
            num /= 10;
            i--;
        }
        int a = 1, b = 1, t;
        for (int j = 2; j <= n; j++) {
            if (nums[j-2] != 0 && nums[j-2] * 10 + nums[j-1] < 26) {
                t = a;
                a = b;
                b = t + b;
            } else {
                a = b;
            }
        }
        return b;
    }
}
