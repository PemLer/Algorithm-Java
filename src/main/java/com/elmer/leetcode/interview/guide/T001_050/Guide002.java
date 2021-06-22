package com.elmer.leetcode.interview.guide.T001_050;

import java.util.*;

public class Guide002 {

    public static int solve(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int len = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                if (set.contains(j)) {
                    break;
                }
                set.add(j);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (j - i == max - min) {
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr));
    }
}
