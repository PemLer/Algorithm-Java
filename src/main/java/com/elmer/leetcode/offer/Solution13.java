package com.elmer.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution13 {

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        boolean[][] mem = new boolean[m][n];
        mem[0][0] = true;
        res += 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int i = tmp[0];
            int j = tmp[1];
            if (j+1 < n && !mem[i][j+1] && calSum(i, j+1) <= k) {
                res += 1;
                mem[i][j+1] = true;
                queue.add(new int[]{i, j+1});
            }
            if (i+1 < m && !mem[i+1][j] && calSum(i+1, j) <= k) {
                res += 1;
                mem[i+1][j] = true;
                queue.add(new int[]{i+1, j});
            }
        }
        return res;
    }

    private int calSum(int i, int j) {
        int res = 0;
        res += calSum(i);
        res += calSum(j);
        return res;
    }

    private int calSum(int i) {
        int res = 0;
        while (i != 0) {
            res += (i % 10);
            i /= 10;
        }
        return res;
    }
}
