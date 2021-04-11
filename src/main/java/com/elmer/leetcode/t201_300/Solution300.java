package com.elmer.leetcode.t201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution300 {

    // 方法一 dp O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int res = 1;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                    res = Math.max(res, dp[i]);
//                }
//            }
//        }
//        return res;
//    }

    // 方法二 贪心+二分 O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n+1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len + 1, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (d[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                d[left] = nums[i];
            }
        }
        return len;
    }
}
