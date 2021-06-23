package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide016 {

    public static int solve(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[j] = matrix[i][j] == 0 ? 0 : f[j] + 1;
            }
            maxArea = Math.max(maxArea, maxArea(f));
        }
        return maxArea;
    }

    private static int maxArea(int[] f) {
        int n = f.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && f[stack.peek()] > f[i]) {
                int index = stack.pop();
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * f[index]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int index = stack.pop();
            int width = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, width * f[index]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int m = Integer.parseInt(items[0]), n = Integer.parseInt(items[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(matrix));
    }
}
