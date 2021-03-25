package com.elmer.leetcode.t401_500;

import java.util.Stack;

public class Solution456 {
    // 132模式
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minList = new int[n];
        minList[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minList[i] = Math.min(minList[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int topNum = Integer.MIN_VALUE;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                topNum = stack.pop();
            }
            if (minList[i] < topNum) {
                return true;
            }
            stack.add(nums[i]);
        }
        return false;
    }
    // [3,5,0,3,4]
    public static void main(String[] args) {
        Solution456 sol = new Solution456();
        int[] nums = new int[]{3,5,0,3,4};
        sol.find132pattern(nums);
    }
}
