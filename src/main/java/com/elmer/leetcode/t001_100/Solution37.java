package com.elmer.leetcode.t001_100;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        for (int m = i; m < 9; m++) {
            for (int n = j; n < 9; n++) {
                if (board[m][n] == '.') {
                    for (int d = 1; d < 10; d++) {
                        board[m][n] = (char)(48 + d);
                        if (checkValid(board, m, n) && helper(board, m, n)) {
                            return true;
                        }
                        board[m][n] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkValid(char[][] board, int i, int j) {
        char t = board[i][j];
        board[i][j] = '.';
        for (char val : board[i]) {
            if (val == t) return false;
        }
        for (int m = 0; m < 9; m++) {
            if (board[m][j] == t) return false;
        }
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (board[(i/3)*3+m][(j/3)*3+n] == t) {
                    return false;
                }
            }
        }
        board[i][j] = t;
        return true;
    }
}
