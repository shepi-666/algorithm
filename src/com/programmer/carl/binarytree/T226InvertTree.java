package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 15:17
 * @description:
 */
public class T226InvertTree {


    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        return invert(root);

    }

    /**
     * 递归的方式翻转二叉树
     * @param root
     * @return
     */
    private TreeNode invert(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
