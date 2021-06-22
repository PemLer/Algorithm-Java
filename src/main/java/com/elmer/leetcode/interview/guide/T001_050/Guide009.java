package com.elmer.leetcode.interview.guide.T001_050;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Guide009 {

    private static int solve(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
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
