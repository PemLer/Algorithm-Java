package com.elmer.leetcode.t801_;

import java.util.Arrays;
import java.util.List;

public class Solution1239 {
    List<String> arr;
    int[] codes;
    int n, res, tmp, preCode;
    public int maxLength(List<String> arr) {
        this.arr = arr;
        int n = arr.size();
        this.n = n;
        res = 0;
        tmp = 0;
        preCode = 0;
        codes = new int[n];
        for (int i = 0; i < n; i++) {
            codes[i] = getCode(arr.get(i));
        }
        dfs(0);
        return res;
    }

    private void dfs(int index) {
        if (index == n) {
            res = Math.max(res, tmp);
            return;
        }
        dfs(index + 1);
        if (codes[index] == 0) return;
        int val = calSum(preCode, codes[index]);
        if (val != 0) {
            preCode = val;
            tmp += arr.get(index).length();
            dfs(index + 1);
            preCode ^= codes[index];
            tmp -= arr.get(index).length();
        }
    }

    private int getCode(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int n = word.charAt(i) - 'a';
            if (((1 << n) & res) != 0) {
                return 0;
            }
            res |= (1 << n);
        }
        return res;
    }

    private int calSum(int n1, int n2) {
        int val = n1 & n2;
        if (val != 0) return 0;
        else return n1 | n2;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("cha","r","act","ers");
        Solution1239 sol = new Solution1239();
        sol.maxLength(arr);
        int[] nums = {133, 131072, 524293, 393232};
        for (String a : arr) {
            int code = sol.getCode(a);
            System.out.println(code);
            System.out.println(Integer.toBinaryString(code));
        }

        for (int  num: nums) {
            System.out.println(Integer.toBinaryString(num));
        }

        System.out.println(sol.calSum(nums[0], nums[2]));
    }
}
