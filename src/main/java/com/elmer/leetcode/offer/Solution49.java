package com.elmer.leetcode.offer;

public class Solution49 {
    public int nthUglyNumber(int n) {
        // 1 2 3 5
        // 1 2 3 4 5 6 8 9 10 12
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int ta = dp[a] * 2, tb = dp[b] * 3, tc = dp[c] * 5;
            dp[i] = Math.min(Math.min(ta, tb), tc);
            if (dp[i] == ta) a++;
            if (dp[i] == tb) b++;
            if (dp[i] == tc) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution49 sol = new Solution49();
        sol.nthUglyNumber(10);
    }
}
