package com.elmer.leetcode;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = 0;
            }
        }
        modify(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println((char)57);
    }

    private static void modify(int[][] matrix) {
        matrix[0][0] = 1;
    }
}
