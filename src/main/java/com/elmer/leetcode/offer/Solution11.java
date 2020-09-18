package com.elmer.leetcode.offer;

public class Solution11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int[] number = new int[]{1};
        System.out.println(sol.minArray(number));
    }
}
