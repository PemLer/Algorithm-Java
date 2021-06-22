package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide014 {

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        int[] h = new int[n + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != n; i++) {
            sum += nums[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != n; i++) {
            sum += nums[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    private static int getLessIndex(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
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
