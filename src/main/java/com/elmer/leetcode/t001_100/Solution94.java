package com.elmer.leetcode.t001_100;

import com.elmer.leetcode.common.ListNode;
import com.elmer.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution94 {
    // Morris 对于x节点
    // 如果有左子树
    //     找到左子树的最右节点，为x的前驱节点 predecessor，根据 predecessor 的右节点是否存在
    //     1 右节点为空，则右指向x，并访问x的左节点，x = x.left
    //     2 右节点不为空，则说明左子树已经访问完了，结果集中添加x，断开链接，并访问x的右子树，x = x.right
    // 否则
    //     将x添加到结果集中，在访问x的右孩子，即 x = x.left
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                // predecessor不为null，并且前驱的右不是root
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向root，继续遍历子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } // 说明左子树已经访问完了，需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
