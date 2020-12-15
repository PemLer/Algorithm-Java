package com.elmer.leetcode.t301_400;

import java.util.*;

public class Solution380 {
}

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    private void swapToTail(int index) {
        int n = list.size();
        int tmp = list.get(n - 1);
        list.set(n - 1, list.get(index));
        list.set(index, tmp);
        map.put(tmp, index);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            swapToTail(index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

