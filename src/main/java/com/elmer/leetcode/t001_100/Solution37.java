package com.elmer.leetcode.t001_100;

public class Solution37 {
    // 空间换时间，用三个多维数组记录访问记录
    char[][] board;
    boolean[][] useRow;
    boolean[][] useCol;
    boolean[][][] useUnit;
    public void solveSudoku(char[][] board) {
        useRow = new boolean[9][10];
        useCol = new boolean[9][10];
        useUnit = new boolean[3][3][10];
        this.board = board;
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = board[i][j] - '0';
                if (1 <= num && num <= 9) {
                    useRow[i][num] = true;
                    useCol[j][num] = true;
                    useUnit[i/3][j/3][num] = true;
                }
            }
        }
        backTrack(0, 0);
    }

    private boolean backTrack(int i, int j) {
        if (j == 9) {
            i++;
            j = 0;
        }
        if (i == 9) {
            return true;
        }

        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (useRow[i][k] || useCol[j][k] || useUnit[i/3][j/3][k]) {
                    continue;
                }
                useRow[i][k] = true;
                useCol[j][k] = true;
                useUnit[i/3][j/3][k] = true;
                board[i][j] = (char) (k + '0');
                if (backTrack(i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
                useRow[i][k] = false;
                useCol[j][k] = false;
                useUnit[i/3][j/3][k] = false;
            }
        } else {
            return backTrack(i, j + 1);
        }
        return false;
    }
}
