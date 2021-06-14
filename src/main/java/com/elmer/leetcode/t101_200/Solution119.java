package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>() {{ add(1); }};
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 0; j < res.size() - 1; j++) {
                tmp.add(res.get(j) + res.get(j + 1));
            }
            tmp.add(1);
            res = tmp;
        }
        return res;
    }
}
