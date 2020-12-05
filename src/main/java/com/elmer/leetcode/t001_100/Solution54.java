package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] mem;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        mem = new boolean[n][m];
        int k = 0, i = 0, j = 0, d = 0;
        List<Integer> res = new ArrayList<>();
        while (k < m * n) {
            res.add(matrix[i][j]);
            k++;
            mem[i][j] = true;
            int x = i + dx[d], y = j + dy[d];
            if (x >= 0 && x < n && y >= 0 && y < m && !mem[x][y]) {
                i = x;
                j = y;
            } else {
                d = (d + 1) % 4;
                i += dx[d];
                j += dy[d];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution54 sol = new Solution54();
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        sol.spiralOrder(matrix);
    }
}
