package com.elmer.leetcode.guide.linkedList;

import java.util.Scanner;
import java.util.Stack;

public class Main_1_9 {

    public int getMaxArea(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0, m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == 0 ? 0 : dp[j] + 1;
            }
            maxArea = Math.max(maxArea, cal(dp));
        }
        return maxArea;
    }

    private int cal(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, n = arr.length;
        stack.add(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * arr[index]);
            }
            stack.add(i);
        }
        while (stack.peek() != -1) {
            int index = stack.pop();
            res = Math.max(res, (n - stack.peek() - 1) * arr[index]);
        }
        return res;
    }

    public static void main(String[] args) {
        Main_1_9 main = new Main_1_9();
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int m = Integer.parseInt(items[0]), n = Integer.parseInt(items[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int res = main.getMaxArea(matrix);
        System.out.println(res);
    }
}
