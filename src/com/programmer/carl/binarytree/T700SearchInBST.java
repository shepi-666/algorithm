package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 16:13
 * @description:
 */
public class T700SearchInBST {

    /**
     * BST 中的搜索
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) {
            // 搜索左子树
            searchBST(root.left, val);
        } else {
            searchBST(root.right, val);
        }
        return null;
    }
}
