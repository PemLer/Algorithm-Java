package com.elmer.leetcode.t201_300;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution295 {
    private Queue<Integer> heap1;
    private Queue<Integer> heap2;

    public Solution295() {
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
