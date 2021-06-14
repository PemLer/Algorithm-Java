package com.elmer.leetcode.t101_200;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int total = numbers[left] + numbers[right];
            if (total < target) {
                left++;
            } else if (total > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
