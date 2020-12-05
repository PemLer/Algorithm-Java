package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    // 贪心算法
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int pos = intervals[0][1], start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s > pos) {
                list.add(new int[]{start, pos});
                start = s;
                pos = e;
            } else {
                pos = Math.max(pos, e);
            }
        }
        list.add(new int[]{start, pos});
        return list.toArray(new int[list.size()][]);
    }
}
