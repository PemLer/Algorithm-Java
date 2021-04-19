package com.elmer.leetcode.t201_300;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution220 {

    // 方法一 滑动窗口
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        // x - t ~ x + t
//        int n = nums.length;
//        TreeSet<Long> set = new TreeSet<>();
//
//        for (int i = 0; i < n; i++) {
//            Long ceiling = set.ceiling((long) nums[i] - (long) t);
//            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
//                return true;
//            }
//            set.add((long) nums[i]);
//            if (i >= k) {
//                set.remove((long) nums[i - k]);
//            }
//        }
//        return false;
//    }

    // 方法二 桶
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // t = 3
        // 0 1 2 3
        // 4 5 6 7
        int n = nums.length;
        Map<Long, Long> bucket = new HashMap<>();
        long w = t + 1;
        for (int i = 0; i < n; i++) {
            long id = getId(nums[i], w);
            if (bucket.containsKey(id)) {
                return true;
            }
            if (bucket.containsKey(id - 1) && Math.abs(nums[i] - bucket.get(id - 1)) < w) {
                return true;
            }
            if (bucket.containsKey(id + 1) && Math.abs(nums[i] - bucket.get(id + 1)) < w) {
                return true;
            }
            bucket.put(id, (long)nums[i]);
            if (i >= k) {
                bucket.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
