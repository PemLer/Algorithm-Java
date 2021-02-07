package com.elmer.leetcode.guide.stack_and_queue;

import java.util.Scanner;

public class Main_1_11 {

    public static int getMountNum(int num) {
        if (num <= 1) return 0;
        return num * 2 - 3;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNum = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testNum; i++) {
            String[] strings = in.nextLine().split(" ");
            System.out.println(getMountNum(Integer.parseInt(strings[0])));
        }
    }
}
