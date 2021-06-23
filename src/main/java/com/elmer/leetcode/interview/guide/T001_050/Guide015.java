package com.elmer.leetcode.interview.guide.T001_050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Guide015 {

    private static int[] solve(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] res = new int[n - k + 1];
        res[0] = deque.peekFirst();
        int index = 1;
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            res[index++] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), window = Integer.parseInt(items[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] res = solve(nums, window);
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            sb.append(r).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
