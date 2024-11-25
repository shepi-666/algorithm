package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 15:30
 * @description:
 */
public class T101SymmetricTree {

    /**
     * 判断是否为对称的二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        // 判断两个子树是否符合轴对称
        return symmetric(root.left, root.right);
    }

    /**
     * 判断两个树是否轴对称
     * @param left
     * @param right
     */
    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null || right == null && left != null) return false;
        if (left == null && right == null) return true;

        // 两个树都不是 null
        if (left.val != right.val) return false;
        return symmetric(left.right, right.left) && symmetric(left.left, right.right);
    }
}
