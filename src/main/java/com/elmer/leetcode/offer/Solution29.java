package com.elmer.leetcode.offer;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length ==  0) return new int[0];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n * m];
        int i = 0, x = 0, y = 0, orient = 0;
        while (i < m * n) {
            res[i] = matrix[x][y];
            matrix[x][y] = Integer.MIN_VALUE;
            int x1 = x + dx[orient], y1 = y + dy[orient];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && matrix[x1][y1] != Integer.MIN_VALUE) {
                x = x1;
                y = y1;
            } else {
                orient = (orient + 1) % 4;
                x += dx[orient];
                y += dy[orient];
            }
            i++;
        }
        return res;
    }
}
