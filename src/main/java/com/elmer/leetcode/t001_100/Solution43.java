package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int l1 = num1.length(), l2 = num2.length();
        int[] nums1 = new int[l1];
        int[] nums2 = new int[l2];
        for (int i = 0; i < l1; i++) {
            nums1[l1 - i - 1] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < l2; i++) {
            nums2[l2 - i - 1] = num2.charAt(i) - '0';
        }
        int d = 0, carry = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                int r = nums2[i] * nums1[j] + carry;
                carry = add(res, j + d, r);
            }
            if (carry != 0) {
                carry = add(res, nums1.length + d, carry);
            }
            d++;
        }
        Collections.reverse(res);
        StringBuilder builder = new StringBuilder();
        for (int num : res) {
            builder.append(num);
        }
        return builder.toString();
    }

    private int add(List<Integer> res, int index, int num) {
        int carry;
        if (res.size() > index) {
            int ori = res.get(index);
            int numNew = ori + num;
            carry = numNew / 10;
            res.set(index, numNew % 10);
        } else {
            carry = num / 10;
            res.add(num % 10);
        }
        return carry;
    }

    public static void main(String[] args) {
        Solution43 sol = new Solution43();
        System.out.println(sol.multiply("123", "456"));
    }
}
