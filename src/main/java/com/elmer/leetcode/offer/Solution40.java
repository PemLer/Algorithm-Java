package com.elmer.leetcode.offer;


public class Solution40 {

    private int topK;

    public int[] getLeastNumbers(int[] arr, int k) {
        topK = k;
        int index = quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i <= index; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            if (left == topK - 1) return left;
            else return -1;
        }
        int i = left, j = right;
        int base = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        if (i == topK - 1) return i;
        else if (i > topK - 1) return quickSort(nums, left, i - 1);
        else return quickSort(nums, i + 1, right);
    }


    public static void main(String[] args) {
        Solution40 sol = new Solution40();
        int[] nums = {0,0,1,2,4,2,2,3,1,4};
        int k = 8;
        sol.getLeastNumbers(nums, k);
    }
}
