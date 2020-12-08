package com.elmer.leetcode.t001_100;

public class Solution12 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while (p < nums.length && num > 0) {
            while (nums[p] <= num) {
                builder.append(strings[p]);
                num -= nums[p];
            }
            p++;
        }
        return builder.toString();
    }
}
