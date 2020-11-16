package com.elmer.leetcode.offer;

import java.util.Stack;

public class Solution33 {

    // 方法一 递归分治 O(n^2)
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && helper(postorder, i, m - 1) && helper(postorder, m, j - 1);
    }

    // 方法二 单调栈 O(N)
//    public boolean verifyPostorder(int[] postorder) {
//        if (postorder.length == 0) return true;
//        int root = Integer.MAX_VALUE;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = postorder.length - 1; i >= 0; i--) {
//            if (postorder[i] > root) return false;
//            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
//                root = stack.pop();
//            }
//            stack.add(postorder[i]);
//        }
//        return true;
//    }
}
