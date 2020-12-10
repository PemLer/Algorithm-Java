package com.elmer.leetcode.t101_200;

public class Solution134 {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length, i = 0;
//        while (i < n) {
//            int sumGas = 0, sumCost = 0, count = 0;
//            while (count < n) {
//                int j = (i + count) % n;
//                sumCost += cost[j];
//                sumGas += gas[j];
//                if (sumCost > sumGas) {
//                    break;
//                }
//                count++;
//            }
//
//            if (count == n) {
//                return i;
//            } else {
//                i = i + count + 1;
//            }
//        }
//        return -1;
//    }
//
    // 方法二
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int remainGas = 0, cur = 0, start = 0;
            for (int i = 0; i < gas.length; i++) {
                remainGas += (gas[i] - cost[i]);
                cur += (gas[i] - cost[i]);
                if (cur < 0) {
                    start = (i + 1) % gas.length;
                    cur = 0;
                }
            }
            return remainGas >= 0 ? start : -1;
        }
    }

}
