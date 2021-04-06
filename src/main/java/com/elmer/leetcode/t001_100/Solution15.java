package com.elmer.leetcode.t001_100;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果与前一个数相同，则continue
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 如果大于0，则后面的数都大于0，找不到和为0的组合了
            if (nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 避免重复
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }

        }
        return res;
    }
}
