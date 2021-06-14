package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>(){{ add(1); }});
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
