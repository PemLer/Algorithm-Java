package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide020 {

    private static int solve(int[] nums) {
        // dp[i][j] 开区间(i, j)的最大值
        // dp[i][j] = max nums[i] * nums[mid] * nums[j] + dp[i][k] + dp[k][j]
        // 3 2 5
        int n = nums.length;
        int[] numNew = new int[n + 2];
        numNew[0] = numNew[n + 1] = 1;
        System.arraycopy(nums, 0, numNew, 1, n);
        int[][] mem = new int[n + 2][n + 2];
        return search(numNew, mem, 0, n + 1);
    }

    private static int search(int[] nums, int[][] mem, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int max = 0;
        for (int mid = i + 1; mid < j; mid++) {
            max = Math.max(nums[i] * nums[mid] * nums[j] + search(nums, mem, i, mid) + search(nums, mem, mid, j), max);
        }
        mem[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve(nums));
    }
}
