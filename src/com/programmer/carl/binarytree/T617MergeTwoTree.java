package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 16:04
 * @description:
 */
public class T617MergeTwoTree {

    /**
     * 合并二叉树
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        else if (root2 == null) return root1;

        // 将两个节点的值相加
        TreeNode root = new TreeNode(root1.val + root2.val);
        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        TreeNode rightNode = mergeTrees(root1.right, root2.right);

        // 构建树
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
