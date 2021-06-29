package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Scanner;

public class Guide021 {

    private static long solve(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, new int[n], 0, n - 1);
    }

    private static long mergeSort(int[] nums, int[] tmp, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int mid = (i + j) / 2;
        long l = mergeSort(nums, tmp, i, mid);
        long r = mergeSort(nums, tmp, mid + 1, j);
        long res = 0;
        int left = i, right = mid + 1, index = i;
        while (left <= mid && right <= j) {
            if (nums[left] <= nums[right]) {
                tmp[index] = nums[left];
                res += (long) nums[left] * (j - right + 1);
                left++;
            } else {
                tmp[index] = nums[right];
                right++;
            }
            index++;
        }
        while (left <= mid) {
            tmp[index++] = nums[left++];
        }
        while (right <= j) {
            tmp[index++] = nums[right++];
        }
        System.arraycopy(tmp, i, nums, i, j - i + 1);
        return l + r + res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve(nums));
    }
}
