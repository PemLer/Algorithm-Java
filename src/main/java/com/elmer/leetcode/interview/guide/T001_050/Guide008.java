package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide008 {

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int left = 0, right = 0, total = nums[0];
        int maxLen = -1;
        while (right < n) {
            if (total == k) {
                maxLen = Math.max(maxLen, right - left + 1);
                total -= nums[left];
                left++;
            } else if (total > k) {
                total -= nums[left];
                left++;
            } else {
                right++;
                if (right < n) {
                    total += nums[right];
                }
            }
        }
        return maxLen;
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
