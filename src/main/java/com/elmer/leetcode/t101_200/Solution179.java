package com.elmer.leetcode.t101_200;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
//        quickSort(strings, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        boolean isZero = true;
        for (String s : strings) {
            if (isZero && "0".equals(s)) continue;
            if (!"0".equals(s)) isZero = false;
            builder.append(s);
        }
        if (builder.length() == 0) return "0";
        return builder.toString();
    }

    private void quickSort(String[] strings, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        String base = strings[i];
        while (i < j) {
            while (i < j && (base + strings[j]).compareTo(strings[j] + base) > -1) {
                j--;
            }
            if (i < j) {
                strings[i] = strings[j];
                i++;
            }
            while (i < j && (base + strings[i]).compareTo(strings[i] + base) < 1) {
                i++;
            }
            if (i < j) {
                strings[j] = strings[i];
                j--;
            }
        }
        strings[i] = base;
        quickSort(strings, start, i - 1);
        quickSort(strings, i + 1, end);
    }

    public static void main(String[] args) {
        Solution179 sol = new Solution179();
        sol.largestNumber(new int[]{10, 2});
    }
}
