package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide023 {

    private static void solve(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        solve(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
