package com.elmer.leetcode.t301_400;

import java.util.*;

public class Solution347 {

    class Status implements Comparable<Status> {

        int val;
        int freq;

        public Status(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Status status) {
            return this.freq - status.freq;
        }
    }

    int k;
    public int[] topKFrequent(int[] nums, int k) {
        this.k = k;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] numFreq = new int[map.size()][];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            numFreq[i] = new int[]{entry.getKey(), entry.getValue()};
            i++;
        }
        quickSort(numFreq, 0, numFreq.length - 1);
        int[] res = new int[k];
        for (int c = 0; c < k; c++) {
            res[c] = numFreq[c][0];
        }
        return res;
    }

    private void quickSort(int[][] numFreq, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        randomBase(numFreq, start, end);
        int[] base = numFreq[i];
        while (i < j) {
            while (i < j && numFreq[j][1] <= base[1]) {
                j--;
            }
            if (i < j) {
                numFreq[i] = numFreq[j];
                i++;
            }
            while (i < j && numFreq[i][1] >= base[1]) {
                i++;
            }
            if (i < j) {
                numFreq[j] = numFreq[i];
                j--;
            }
        }
        numFreq[i] = base;
        if (i == k) {
            return;
        } else if (i < k) {
            quickSort(numFreq, i + 1, end);
        } else {
            quickSort(numFreq, start, i - 1);
        }
    }

    Random random = new Random();
    private void randomBase(int[][] numFreq, int start, int end) {
        int index = random.nextInt(end - start + 1) + start;
        int[] tmp = numFreq[index];
        numFreq[index] = numFreq[start];
        numFreq[start] = tmp;
    }
}
