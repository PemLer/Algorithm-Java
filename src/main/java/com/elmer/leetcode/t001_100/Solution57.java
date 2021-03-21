package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n1 = newInterval[0], n2 = newInterval[1];
        int n = intervals.length;
        boolean placed = false;
        int l, r;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l = intervals[i][0];
            r = intervals[i][1];
            if (l > n2) {
                if (!placed) {
                    res.add(new int[]{n1, n2});
                    placed = true;
                }
                res.add(intervals[i]);
            } else if (r < n1) {
                res.add(intervals[i]);
            } else {
                n1 = Math.min(n1, l);
                n2 = Math.max(n2, r);
            }
        }
        if (!placed) {
            res.add(new int[]{n1, n2});
        }
        return res.toArray(new int[res.size()][]);
    }
}
