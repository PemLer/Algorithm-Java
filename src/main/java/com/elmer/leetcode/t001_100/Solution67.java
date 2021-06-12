package com.elmer.leetcode.t001_100;

public class Solution67 {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int carry = 0;
        int i = n1 - 1, j = n2 - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int total;
            if (i < 0) {
                total = (b.charAt(j) - '0') + carry;
            } else if (j < 0) {
                total = (a.charAt(i) - '0') + carry;
            } else {
                total = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            }
            sb.append(total % 2);
            carry = total / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
