package com.elmer.leetcode.t001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 000 000 000 000
 *     001 001 001
 *         011 011
 *         010 010
 *             110
 *             111
 *             101
 *             100
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(){{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
