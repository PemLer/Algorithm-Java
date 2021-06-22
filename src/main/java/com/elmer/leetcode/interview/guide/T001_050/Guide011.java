package com.elmer.leetcode.interview.guide.T001_050;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Guide011 {

    private static int solve(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0, total = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                total++;
            } else if (nums[i] == 0) {
                total--;
            }
            if (map.containsKey(total)) {
                len = Math.max(len, i - map.get(total));
            } else {
                map.put(total, i);
            }
        }
        return len;
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
