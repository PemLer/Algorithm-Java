package com.elmer.leetcode.interview.guide.T001_050;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Guide003 {

    private static void solve(int[] arr, int k) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int total = arr[i] + arr[j];
            if (total == k) {
                System.out.println(arr[i] + " " + arr[j]);
                while (i < j && arr[i] == arr[i+1]) {
                    i++;
                }
                while (i < j && arr[j] == arr[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (total < k) {
                i++;
            } else {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), k = Integer.parseInt(items[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(arr, k);
    }
}
