package com.elmer.leetcode.t201_300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        queue.add(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start < queue.peek()) {
                queue.add(end);
            } else {
                queue.poll();
                queue.add(end);
            }
        }
        return queue.size();
    }

//    // 方法二 有序化
//    public int minMeetingRooms(int[][] intervals) {
//        int n = intervals.length;
//        int[] start = new int[n];
//        int[] end = new  int[n];
//        for (int i = 0; i < n; i++) {
//            start[i] = intervals[i][0];
//            end[i] = intervals[i][1];
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//
//        int startPoi = 0, endPoi = 0, count = 0;
//        while (startPoi < n) {
//            if (start[startPoi] >= end[endPoi]) {
//                count--;
//                endPoi++;
//            }
//            count++;
//            startPoi++;
//        }
//        return count;
//    }
}
