package com.elmer.leetcode.t001_100;

public class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        // 上下交换
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        // 对角交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
