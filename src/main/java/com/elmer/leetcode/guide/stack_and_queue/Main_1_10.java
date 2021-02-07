package com.elmer.leetcode.guide.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1_10 {

    public int getNum(int[] arr, int num) {

        if (arr.length == 0 || num == 0) return 0;

        Deque<Integer> dequeMin = new LinkedList<>();
        Deque<Integer> dequeMax = new LinkedList<>();

        int i = 0, j = 0, res = 0, n = arr.length;

        while (i < n) {
            while (j < n) {
                if (dequeMin.isEmpty() || dequeMin.peekLast() != j) {
                    while (!dequeMin.isEmpty() && arr[dequeMin.peekLast()] > arr[j]) {
                        dequeMin.pollLast();
                    }
                    dequeMin.addLast(j);

                    while (!dequeMax.isEmpty() && arr[dequeMax.peekLast()] < arr[j]) {
                        dequeMax.pollLast();
                    }
                    dequeMax.addLast(j);
                }

                if (arr[dequeMax.peekFirst()] - arr[dequeMin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
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
        Main_1_10 main = new Main_1_10();
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int n = Integer.parseInt(items[0]), num = Integer.parseInt(items[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int res = main.getNum(arr, num);
        System.out.println(res);
    }
}
