package com.elmer.leetcode.t001_100;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[pos] = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                nums1[pos] = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {
                nums1[pos] = nums1[p1];
                p1--;
            } else {
                nums1[pos] = nums2[p2];
                p2--;
            }
            pos--;
        }
    }
}
