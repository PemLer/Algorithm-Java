package com.elmer.leetcode.t101_200;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(int[][] points) {
        // [[0,0],[4,5],[7,8],[8,9],[5,6],[3,4],[1,1]]
        int n = points.length;
        int horizon = 1, count = 1, duplicates, maxCount = 1;
        Map<Double, Integer> lines = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            horizon = 1;
            lines.clear();
            count = 1;
            duplicates = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    duplicates++;
                } else if (y1 == y2) {
                    horizon++;
                    count = Math.max(count, horizon);
                } else {
                    double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;  // +0.0 将-0.0和+0.0统一
                    lines.put(slope, lines.getOrDefault(slope, 1) + 1);
                    count = Math.max(count, lines.get(slope));
                }
            }
            maxCount = Math.max(maxCount, count + duplicates);
        }
        return maxCount;
    }
}
