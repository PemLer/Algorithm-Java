package com.elmer.leetcode.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution41 {

//    // 方法一 二分查找
//    private List<Integer> data;
//    /** initialize your data structure here. */
//    public Solution41() {
//        data = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        if (data.size() == 0 || data.get(data.size() - 1) <= num) {
//            data.add(num);
//            return;
//        }
//        int i = 0, j = data.size() - 1;
//        while (i <  j) {
//            int mid = i + j >> 1;
//            if (data.get(mid) <= num) {
//                i = mid + 1;
//            } else {
//                j = mid;
//            }
//        }
//        data.add(i, num);
//    }
//
//    public double findMedian() {
//        int size = data.size();
//        if (size % 2 == 0 && size != 0) {
//            return (data.get(size / 2 - 1) + data.get(size / 2)) / 2.0;
//        } else if (size % 2 == 1) {
//            return data.get(size / 2);
//        } else {
//            return 0;
//        }
//    }

    // 方法二 堆
    private Queue<Integer> heap1;
    private Queue<Integer> heap2;

    public Solution41() {
        heap1 = new PriorityQueue<>((x, y) -> (y - x));  // 大顶堆
        heap2 = new PriorityQueue<>();  // 小顶堆
    }

    public void addNum(int num) {
        if (heap1.size() == heap2.size()) {
            heap2.add(num);
            heap1.add(heap2.poll());
        } else {
            heap1.add(num);
            heap2.add(heap1.poll());
        }
    }

    public double findMedian() {
        if (heap1.size() == heap2.size()) {
            return (heap1.peek() + heap2.peek()) / 2.0;
        } else {
            return heap1.peek();
        }
    }
}
