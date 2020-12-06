package com.elmer.leetcode.t401_500;

public class Solution443 {
    public int compress(char[] chars) {
        int count = 0, i = 0, pos = 0;
        while (i < chars.length) {
            int t = 1;
            chars[pos] = chars[i];
            pos++;
            i++;
            while(i < chars.length && chars[i] == chars[i-1]) {
                t++;
                i++;
            }
            if (t > 1) {
                count += 1;
                int postion = setNum(t, chars, pos);
                count += postion;
                pos += postion;
            }
            else count++;
        }
        return count;
    }

    private int setNum(int t, char[] chars, int pos) {
        int times = (int)Math.log10(t);
        int position = 0;
        while (times != -1) {
            int p = (int)(Math.pow(10, times));
            int num = t / p;
            chars[pos] = (char) ('0' + num);
            pos++;
            t %= p;
            times--;
            position++;
        }
        return position;
    }
}
