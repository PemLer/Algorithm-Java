package com.elmer.leetcode;

import com.elmer.leetcode.common.TreeNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.findMedian();
        mf.addNum(3);
        mf.findMedian();
    }

    private static void modify(int[][] matrix) {
        matrix[0][0] = 1;
    }

    public static class MedianFinder {

        List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            if (list.size() == 0 || list.get(list.size() - 1) <= num) {
                list.add(num);
                return;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                int m = i + (j - i) / 2;
                if (list.get(m) <= num) i = m + 1;
                else j = m;
            }
            list.add(i, num);
        }

        public double findMedian() {
            int n = list.size();
            if (n == 0) return .0;
            else if (list.size() % 2 == 0) {
                return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
            } else {
                return list.get(n / 2);
            }
        }
    }
}
