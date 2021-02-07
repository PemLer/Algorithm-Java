package com.elmer.leetcode.contest.weekly_contest_227;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution5675 {

    int ans = Integer.MAX_VALUE;
    int goal = 0;

    private int[] create(int[] nums) {
        int n = nums.length;
        int[] res = new int[1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << i); j++) {
                res[j + (1 << i)] = res[j] + nums[i];
                ans = Math.min(ans, Math.abs(goal - res[j + (1 << i)]));
            }
        }
        return res;
    }

    public int minAbsDifference(int[] nums, int goal) {
        ans = Integer.MAX_VALUE;
        this.goal = goal;
        int n = nums.length;
        int[] left = create(Arrays.copyOfRange(nums, 0, n / 2));
        int[] right = create(Arrays.copyOfRange(nums, n / 2, n));
        Arrays.sort(left);
        Arrays.sort(right);
        int n1 = left.length, n2 = right.length;
        int i = 0, j = n2 - 1, total;
        while (i < n1 && j >= 0) {
            total = left[i] + right[j];
            if (total > goal) {
                j--;
            } else if (total < goal) {
                i++;
            } else {
                return 0;
            }
            ans = Math.min(ans, Math.abs(goal - total));
        }
        return ans;
    }
}
