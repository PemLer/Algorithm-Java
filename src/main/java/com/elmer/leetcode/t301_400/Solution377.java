package com.elmer.leetcode.t301_400;

import java.util.ArrayList;
import java.util.List;

public class Solution377 {

    public int combinationSum4(int[] nums, int target) {
        // dp[i] 表示和为i的种类数
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int num: nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
