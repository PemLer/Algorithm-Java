package com.elmer.leetcode.t001_100;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int total = n + m;
        if (total % 2 == 1) {
            int k = total / 2;
            return getKthElement(nums1, nums2, k + 1);
        } else {
            int k = total / 2 - 1;
            return (getKthElement(nums1, nums2, k + 1) + getKthElement(nums1, nums2, k + 2)) * 0.5;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) return nums2[index2 + k - 1];
            if (index2 == length2) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);

            // 正常情况
            int half = k / 2;
            int index1New = Math.min(index1 + half, length1) - 1;
            int index2New = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[index1New], pivot2 = nums2[index2New];
            if (pivot1 <= pivot2) {
                k -= (index1New - index1 + 1);
                index1 = index1New + 1;
            } else {
                k -= (index2New - index2 + 1);
                index2 = index2New + 1;
            }
        }
    }
}
