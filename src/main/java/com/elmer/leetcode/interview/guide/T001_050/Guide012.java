package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Arrays;
import java.util.Scanner;

public class Guide012 {

    private static int solve(int[] coins, int k) {
        int[] dp = new int[k + 1];
        int max = k + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[k] != max ? dp[k] : -1;
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
