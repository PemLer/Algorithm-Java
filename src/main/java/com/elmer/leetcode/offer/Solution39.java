package com.elmer.leetcode.offer;

public class Solution39 {
    public int majorityElement(int[] nums) {
        int count = 0, target = 0;
        for  (int num : nums) {
            if (count == 0) target = num;
            count += target == num ? 1 : -1;
        }
        return target;
    }
}
