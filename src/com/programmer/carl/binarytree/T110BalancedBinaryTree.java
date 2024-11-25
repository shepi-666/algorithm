package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.HashMap;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 16:15
 * @description:
 */
public class T110BalancedBinaryTree {

    /**
     * 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        // 左右子树都是平衡二叉树
        if (isBalanced(root.left) && isBalanced(root.right)) {
            // 左右两颗子树的深度相差不到1
            return Math.abs(depth(root.left) - depth(root.right)) <= 1;
        }
        return false;

    }


    HashMap<TreeNode, Integer> memo = new HashMap<>();
    /**
     * 求二叉树的深度
     * @param root
     */
    private int depth(TreeNode root) {
        if (root == null) return 0;

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int maxDepth = Math.max(depth(root.left), depth(root.right)) + 1;
        memo.put(root, maxDepth);
        return maxDepth;
    }


    /**
     * 优化思路，自底向上递归
     * @param root
     * @return
     */
    public boolean isBalancedI(TreeNode root) {
        if (root == null) return true;

        return height(root) >= 0;
    }

    /**
     * 判断树的深度
     * @param root
     * @return
     */
    private int height(TreeNode root) {

        if (root == null) return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (lHeight == -1 || rHeight == -1 || Math.abs(rHeight - lHeight) > 1) {
            return -1;
        }
        else {
            return Math.max(lHeight, rHeight) + 1;
        }
    }
}
