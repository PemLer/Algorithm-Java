package com.elmer.leetcode.t301_400;

public class Solution348 {
    class TicTacToe {

        int[][] matrix;
        int extra;
        int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            matrix = new int[n+1][n+1];
            extra = 0;
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int num = player == 1 ? 1 : -1;
            if (row + col == n - 1) extra += num;
            if (row == col) matrix[n][n] += num;
            matrix[row][n] += num;
            matrix[n][col] += num;
            int win = num * n;
            if (extra == win || matrix[n][n] == win || matrix[row][n] == win || matrix[n][col] == win) return player;
            return 0;
        }
    }

}
