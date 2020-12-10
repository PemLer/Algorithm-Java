package com.elmer.leetcode.t001_100;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = n * m, mid;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (getValue(matrix, n, m, mid) < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i != n * m && getValue(matrix, n, m, i) == target;
    }

    private int getValue(int[][] matrix, int n, int m, int index) {
        int i = index / m, j = index % m;
        return matrix[i][j];
    }
}
