package com.elmer.leetcode.offer;

import java.util.Arrays;

public class Solution45 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
//        quickSort(strings, 0, strings.length - 1);
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (String s: strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void quickSort(String[] strings, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        String base = strings[i];
        while (i < j) {
            while (i < j && (strings[j] + base).compareTo(base + strings[j]) >= 0) j--;
            if (i < j) {
                strings[i] = strings[j];
                i++;
            }
            while (i < j && (strings[i] + base).compareTo(base + strings[i]) <= 0) i++;
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
        String[] strings = {"30", "3", "289"};
//        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        Arrays.sort(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
