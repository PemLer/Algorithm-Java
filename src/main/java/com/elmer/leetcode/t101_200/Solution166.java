package com.elmer.leetcode.t101_200;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        long num1 = numerator, num2 = denominator;
        if (num1 * num2 < 0) {
            builder.append("-");
        }
        num1 = num1 < 0 ? -num1 : num1;
        num2 = num2 < 0 ? -num2 : num2;

        builder.append(num1 / num2);
        builder.append(".");

        Map<Long, Integer> map = new HashMap<>();
        long num = (num1 % num2) * 10;
        while (num != 0) {
            if (map.containsKey(num)) {
                int index = map.get(num);
                builder.insert(index, "(");
                builder.append(")");
                break;
            }
            map.put(num, builder.length());
            builder.append(num / num2);
            num = (num % num2) * 10;
        }
        if (builder.charAt(builder.length() - 1) == '.') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution166 sol = new Solution166();
        int[][] nums = {{1, 2}, {2, 1}, {2, 3}, {4, 333}, {1, 5}, {-1, -2147483648}};
        for (int[] ints : nums) {
            System.out.println(sol.fractionToDecimal(ints[0], ints[1]));
        }
    }
}
