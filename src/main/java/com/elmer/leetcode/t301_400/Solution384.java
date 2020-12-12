package com.elmer.leetcode.t301_400;

import java.util.Arrays;
import java.util.Random;

public class Solution384 {
}

class Solution {

    int[] nums;
    int[] numsShuttled;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        numsShuttled = Arrays.copyOf(nums, nums.length);
//        doShuffle();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        doShuffle();
        return numsShuttled;
    }

    private void doShuffle() {
        for (int i = 1; i < numsShuttled.length; i++) {
            int index = random.nextInt(i + 1);
            swap(numsShuttled, i, index);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}