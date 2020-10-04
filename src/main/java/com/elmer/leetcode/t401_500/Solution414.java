package com.elmer.leetcode.t401_500;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution414 {

    // 方法一 TreeSet
//    public int thirdMax(int[] nums) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int num : nums) {
//            set.add(num);
//            if (set.size() > 3) set.pollFirst();
//        }
//        return set.size() < 3 ? set.last() : set.first();
//    }

    // 方法二 维护三个变量
    public int thirdMax(int[] nums) {
        long MIN = Long.MIN_VALUE;  // 测试用例中有Integer.MIN_VALUE，所以这里使用long
        long one = MIN, two = MIN, third = MIN;
        for (int num : nums) {
            if (num == one || num == two || num == third) continue;
            if (num > one) {
                third = two;
                two = one;
                one = num;
            } else if (num > two) {
                third = two;
                two = num;
            } else if (num > third) {
                third = num;
            }
        }
        if (third == MIN) return (int)one;
        else return (int)third;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1,9,0,2,1};
        Solution414 sol = new Solution414();
        int res = sol.thirdMax(nums);
        System.out.println(res);
    }
}
