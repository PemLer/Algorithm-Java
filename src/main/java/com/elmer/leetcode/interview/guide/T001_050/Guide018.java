package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide018 {

    private static int solve(int[] nums, int k) {
        Deque<Integer> dequeMin = new LinkedList<>();
        Deque<Integer> dequeMax = new LinkedList<>();
        int n = nums.length, i = 0, j = 0, res = 0;
        while (i < n) {
            while (j < n) {
                while (!dequeMin.isEmpty() && nums[dequeMin.peekLast()] >= nums[j]) {
                    dequeMin.pollLast();
                }
                dequeMin.addLast(j);
                while (!dequeMax.isEmpty() && nums[dequeMax.peekLast()] <= nums[j]) {
                    dequeMax.pollLast();
                }
                dequeMax.addLast(j);
                if (nums[dequeMax.peekFirst()] - nums[dequeMin.peekFirst()] > k) {
                    break;
                }
                j++;
            }
            // 从上面循环break出来的之前的都是满足条件的
            res += (j - i);
            if (dequeMin.peekFirst() == i) {
                dequeMin.pollFirst();
            }
            if (dequeMax.peekFirst() == i) {
                dequeMax.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), k = Integer.parseInt(items[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve(nums, k));
    }
}
