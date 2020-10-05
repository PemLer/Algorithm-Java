package com.elmer.leetcode.offer;

public class Solution51 {

    private int res;
    public int reversePairs(int[] nums) {
        res = 0;
        int n = nums.length;
        int[] tmp = new int[n];
        mergeSort(nums, tmp, 0, nums.length - 1);
        return res;
    }

    private int[] mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) return null;
        int mid = left + right >> 1;
        mergeSort(nums, tmp, left, mid);
        mergeSort(nums, tmp, mid + 1, right);
        int i = left, j = mid + 1, pos = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[pos] = nums[i];
                i++;
                res += (j - mid - 1);  // 将第i个元素加入tmp，说明当前j之前的元素与i元素都构成逆序对
            } else {
                tmp[pos] = nums[j];
                j++;
            }
            pos++;
        }
        for (int k = i; k <= mid; k++) {
            tmp[pos] = nums[k];
            pos++;
            res += (right - mid);
        }
        for (int k = j; k <= right; k++) {
            tmp[pos] = nums[k];
            pos++;
        }
        System.arraycopy(tmp, left, nums, left, right - left + 1);
        return nums;
    }
}
