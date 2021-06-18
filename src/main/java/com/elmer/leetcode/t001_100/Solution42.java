package com.elmer.leetcode.t001_100;

import java.util.Deque;
import java.util.LinkedList;

public class Solution42 {

    // 方法一 单调栈
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int cur = 0; cur < height.length; cur++) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int base = stack.pop();
                if (stack.isEmpty()) break;
                int distance = cur - stack.peek() - 1;
                int h = Math.min(height[cur], height[stack.peek()]) - height[base];
                res += distance * h;
            }
            stack.push(cur);
        }
        return res;
    }

//    // 方法二 双指针
//    public int trap(int[] height) {
//        int n = height.length;
//        int left = 0, right = n  - 1;
//        int left_max= 0, right_max = 0, ans = 0;
//        while (left < right) {
//            left_max = Math.max(left_max, height[left]);
//            right_max = Math.max(right_max, height[right]);
//            if (height[left] < height[right]) {
//                ans += (left_max - height[left]);
//                left++;
//            } else {
//                ans += (right_max - height[right]);
//                right--;
//            }
//        }
//        return ans;
//    }
}
