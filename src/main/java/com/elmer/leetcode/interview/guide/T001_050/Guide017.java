package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide017 {

    public static int solve(int n, int m, int k, int p) {
        // dp[i][j] 到 i 走 j 步的数量
        // dp[i][j] = dp[i-1][j-1] + dp[i+1][j-1]
        int mod = 1000000007;
        int[][] dp = new int[n+2][k+1];
        dp[m][0] = 1;
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i+1][j-1]) % mod;
            }
        }
        return dp[p][k];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]);
        int m = Integer.parseInt(items[1]);
        int k = Integer.parseInt(items[2]);
        int p = Integer.parseInt(items[3]);
        System.out.println(solve(n, m, k, p));
    }
}
