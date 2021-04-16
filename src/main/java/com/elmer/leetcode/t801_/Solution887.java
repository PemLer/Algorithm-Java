package com.elmer.leetcode.t801_;

import java.util.HashMap;
import java.util.Map;

public class Solution887 {
    Map<Integer, Integer> mem;

    public int superEggDrop(int k, int n) {
        // dp(k, n) k个鸡蛋n层楼的最小值 k 1~100 n 1~10^4
        // dp(k, n) = min_{x} max(dp(k, n - x), dp(k - 1, x - 1))
        mem = new HashMap<>();

        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int key = n * 100 + k;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        int left = 1, right = n;
        while (left + 1 < right) {
            int x = left + right >> 1;
            int t1 = dp(k - 1, x - 1);
            int t2 = dp(k, n - x);

            if (t1 < t2) {
                left = x;
            } else if (t1 > t2) {
                right = x;
            } else {
                left = right = x;
            }
        }
        int ans = 1 + Math.min(Math.max(dp(k - 1, left - 1), dp(k, n - left)), Math.max(dp(k - 1, right - 1), dp(k, n - right)));
        mem.put(key, ans);
        return ans;
    }
}
