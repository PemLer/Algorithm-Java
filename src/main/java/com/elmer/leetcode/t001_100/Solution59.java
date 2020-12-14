package com.elmer.leetcode.t001_100;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direct = 0, count = 0;
        while (count < n * n) {
            count++;
            matrix[i][j] = count;
            int x = i + dx[direct], y = j + dy[direct];
            if (x < 0 || x >= n || y < 0 || y >= n || matrix[x][y] != 0) {
                direct = (direct + 1) % 4;
                x = i + dx[direct];
                y = j + dy[direct];
            }
            i = x;
            j = y;
        }
        return matrix;
    }
}
