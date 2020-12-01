package com.elmer.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> record = new ArrayList<>();
        int l = 1, r = 2, sum;
        while (l < r) {
            sum = (l + r) * (r - l + 1) / 2;
            if (sum > target) {
                l++;
            } else if (sum < target) {
                r++;
            } else {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                record.add(res);
                l++;
            }
        }
        return record.toArray(new int[record.size()][]);
    }
}
