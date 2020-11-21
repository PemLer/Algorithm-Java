package com.elmer.leetcode.t201_300;

import java.util.Random;

public class Solution215 {
    int k;
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        return quickSort(nums, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            if (start + 1 == k) return nums[start];
            else return -1;
        }
        int i = start, j = end;
        // 随机选取一个base
        randomSwap(nums, i, j);
        int base = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= base) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] >= base) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        if (i + 1 == k) {
            return nums[i];
        } else if (i + 1 > k) {
            return quickSort(nums, start, i);
        } else {
            return quickSort(nums, i + 1, end);
        }
    }

    /**
     * 随机交换第一个元素
     */
    private void randomSwap(int[] nums, int i, int j) {
        int index = random.nextInt(j - i + 1) + i;
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
