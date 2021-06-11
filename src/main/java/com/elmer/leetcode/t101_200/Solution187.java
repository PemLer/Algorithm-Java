package com.elmer.leetcode.t101_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        Set<String> res = new HashSet<>();
        Set<Integer> record = new HashSet<>();

        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            num = (num << 2) | map[chars[i] - 'A'];
        }
        record.add(num);
        for (int i = 10; i < s.length(); i++) {
            num = (num << 2) | map[chars[i] - 'A'];
            num &= 0xfffff;  // 掩码去除高位，只保留20位的结果
            if (record.contains(num)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                record.add(num);
            }
        }
        return new ArrayList<>(res);
    }
}
