package com.elmer.leetcode.t101_200;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> record = new HashSet<>();
        for (int num : nums) {
            record.add(num);
        }
        int maxCount = 1;
        for (int num : record) {
            if (!record.contains(num - 1)) {
                int c = 0, n = num;
                while (record.contains(n)) {
                    n++;
                    c++;
                }
                maxCount = Math.max(maxCount, c);
            }
        }
        return maxCount;
    }
}
