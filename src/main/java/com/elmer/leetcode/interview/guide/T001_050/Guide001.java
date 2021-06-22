package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide001 {

    public static boolean exist(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] > k) {
                j--;
            } else if (matrix[i][j] < k) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]), k = Integer.parseInt(items[2]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        if (exist(matrix, k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
