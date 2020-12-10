package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    // 方法一 回溯
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTracing(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTracing(int[] nums, int x, List<Integer> tmp) {
        if (x == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        backTracing(nums, x + 1, tmp);
        tmp.add(nums[x]);
        backTracing(nums, x + 1, tmp);
        tmp.remove(tmp.size() - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

//    // 方法二 位运算实现
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int n = nums.length;
//        for (int i = 0; i < Math.pow(2, n); i++) {
//            List<Integer> tmp = new ArrayList<>();
//            int k = 0, c = i;
//            while (c != 0) {
//                if ((c & 1) == 1) {
//                    tmp.add(nums[k]);
//                }
//                c >>= 1;
//                k++;
//            }
//            res.add(tmp);
//        }
//        return res;
//    }
}
