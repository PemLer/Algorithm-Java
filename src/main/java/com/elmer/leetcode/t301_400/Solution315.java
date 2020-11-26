package com.elmer.leetcode.t301_400;

import java.util.ArrayList;
import java.util.List;

public class Solution315 {

    private int[] res;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        res = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, new int[n], index, new int[n], 0, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (Integer r : res) {
            ans.add(r);
        }
        return ans;
    }

    private void mergeSort(int[] nums, int[] tmp, int[] index, int[] indexTmp, int start, int end) {
        if (start >= end) return;
        int mid = start + end >> 1;
        mergeSort(nums, tmp, index, indexTmp, start, mid);
        mergeSort(nums, tmp, index, indexTmp, mid + 1, end);
        int i = start, j = mid + 1, pos = start;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[pos] = nums[i];
                indexTmp[pos] = index[i];
                res[index[i]] += (j - mid - 1);
                i++;
            } else {
                tmp[pos] = nums[j];
                indexTmp[pos] = index[j];
                j++;
            }
            pos++;
        }
        for (int k = i; k <= mid; k++) {
            tmp[pos] = nums[k];
            indexTmp[pos] = index[k];
            res[index[k]] += (end - mid);
            pos++;
        }
        for (int k = j; k <= end; k++) {
            tmp[pos] = nums[k];
            indexTmp[pos] = index[k];
            pos++;
        }
        for (int k = start; k <= end; k++) {
            nums[k] = tmp[k];
            index[k] = indexTmp[k];
        }
    }
}
