package com.elmer.leetcode.t201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution300 {

//    // 方法一 dp O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        if (n == 0) return 0;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int res = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
//                    dp[i] = dp[j] + 1;
//                    res = Math.max(dp[i], res);
//                }
//            }
//        }
//        return res;
//    }

    // 方法二 贪心+二分 O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = 0, right = res.size(), mid;
            while (left < right) {
                mid = left + right >> 1;
                if (res.get(mid) < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left < res.size()) {
                res.set(left, nums[i]);
            } else {
                res.add(nums[i]);
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        Solution300 sol = new Solution300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        sol.lengthOfLIS(nums);
    }
}
// [10,9,2,5,3,7,101,18]
// [1,3,6,7,9,4,10,5,6]