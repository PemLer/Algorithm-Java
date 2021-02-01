package com.elmer.leetcode.guide;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1_7 {

    Deque<Integer> deque;
    int[] nums;
    int window;
    int index;

    public Main_1_7(int size, int window) {
         deque = new LinkedList<>();
         nums = new int[size];
         this.window = window;
         index = 0;
    }

    public void add(int val) {
        nums[index] = val;
        index++;
    }

    public int[] maxArrayOfWindow() {
        int[] res = new int[nums.length - window + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (!deque.isEmpty() && deque.peekFirst() == i - window) {
                deque.pollFirst();
            }
            if (i >= window - 1) {
                res[i - window + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int size = Integer.parseInt(line[0]), window = Integer.parseInt(line[1]);
        Main_1_7 main = new Main_1_7(size, window);
        for (int i = 0; i < size; i++) {
            int val = in.nextInt();
            main.add(val);
        }
        int[] nums = main.maxArrayOfWindow();
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }



}
