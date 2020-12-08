package com.elmer.leetcode.t001_100;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverseNum = 0, num = x;
        while (x != 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum == num;
    }
}
