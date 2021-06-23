package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide019 {

    private static int solve(int[] coins, int k) {
        // dp[i][j] 使用第 i 种硬币得到 j 的种类数
        int mod = 1000000007;
        int n = coins.length;
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i * coins[0] <= k; i++) {
            dp[0][i * coins[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = (dp[i][j] + (j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0)) % mod;
            }
        }
        return dp[n-1][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), k = Integer.parseInt(items[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve(nums, k));
    }
}
