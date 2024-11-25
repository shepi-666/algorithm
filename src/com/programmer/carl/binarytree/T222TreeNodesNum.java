package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 15:37
 * @description:
 */
public class T222TreeNodesNum {


    private int count = 0;
    /**
     * 完全二叉树节点的个数
     * @param root
     * @return
     */
    public int countNodesI(TreeNode root) {
        if (root == null) return count;

        traverse(root);

        return count;
    }

    /**
     * 树的 前序遍历
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) return;
        count++;
        traverse(root.left);
        traverse(root.right);
    }


    /**
     * 计算当前完全二叉树的节点个数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 判断当前二叉树是否为满二叉树
        int lDepth = 1;
        int rDepth = 1;
        while (left != null) {
            lDepth++;
            left = left.left;
        }
        while (right != null) {
            rDepth++;
            right = right.right;
        }
        // 最左和最右子树的高度一样，是满二叉树，公式求解
        if (rDepth == lDepth) {
            return 1 << rDepth - 1;
        }
        // 不是满二叉树
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
