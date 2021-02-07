package com.elmer.leetcode.guide;

import java.util.Scanner;

public class Main_2_6 {

    // 递归
    private static int getNum(int n, int m) {
        if (n == 1) return 1;
        int p = getNum(n - 1, m);
        return (m + p - 1) % n + 1;
    }

    // 递推
    private static int getNum2(int n, int m) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (m + res - 1) % i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int r = getNum(n, m);
        System.out.println(r);
    }

}
