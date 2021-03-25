package com.elmer.leetcode.t301_400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution341 {
}

interface NestedInteger {

    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}


// 方法一 先dfs进行预处理
//class NestedIterator implements Iterator<Integer> {
//
//    List<Integer> list;
//    Iterator<Integer> iterator;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        list = new ArrayList<>();
//        dfs(nestedList);
//        iterator = list.iterator();
//    }
//
//    @Override
//    public Integer next() {
//        return iterator.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return iterator.hasNext();
//    }
//
//    private void dfs(List<NestedInteger> nestedList) {
//        for (NestedInteger nested : nestedList) {
//            if (nested.isInteger()) {
//                list.add(nested.getInteger());
//            } else {
//                dfs(nested.getList());
//            }
//        }
//    }
//}

class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.add(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> list = new ArrayList<>();
                list.add(nest);
                stack.add(list.iterator());
                return true;
            }
            stack.add(nest.getList().iterator());
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }
}