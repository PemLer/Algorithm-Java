package com.elmer.leetcode.t001_100;


public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean isCol = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) setZero(matrix, i, true);
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) setZero(matrix, j, false);
        }
        if (matrix[0][0] == 0) setZero(matrix, 0, true);
        if (isCol) setZero(matrix, 0, false);
    }

    private void setZero(int[][] matrix, int c, boolean isRow) {
        if (isRow) {
            int[] row = matrix[c];
            for (int k = 0; k < row.length; k++) {
                row[k] = 0;
            }
        } else {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][c] = 0;
            }
        }
    }
}
