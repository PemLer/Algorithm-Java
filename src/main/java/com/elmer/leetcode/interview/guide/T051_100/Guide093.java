package com.elmer.leetcode.interview.guide.T051_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Guide093 {

    public static int solve(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num, 1);
            if (map.containsKey(num - 1)) {
                maxLen = Math.max(maxLen, merge(map, num - 1, num));
            }
            if (map.containsKey(num + 1)) {
                maxLen = Math.max(maxLen, merge(map, num, num + 1));
            }
        }
        return maxLen;
    }

    private static int merge(Map<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int length = right - left + 1;
        map.put(left, length);
        map.put(right, length);
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr));
    }
}
