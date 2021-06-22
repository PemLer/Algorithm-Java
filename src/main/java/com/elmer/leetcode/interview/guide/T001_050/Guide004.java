package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide004 {

    private static void solve(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int total = k - arr[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < total) {
                    left++;
                } else if (sum > total) {
                    right--;
                } else {
                    if (arr[left] != arr[left - 1]) {
                        System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                    }
                    left++;
                    right--;
                }
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
