package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 17:17
 * @description:
 */
public class T404LeftLeaves {


    private int counts = 0;
    /**
     * 所有左叶子节点的和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return counts;
        findLeftLeaves(root);
        return counts;
    }

    /**
     * 递归找到左叶子
     * @param root
     */
    private void findLeftLeaves(TreeNode root) {
        if (root == null) return;
        // 当前节点是非叶子节点
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        // 找到左叶子：左叶子没孩子
        if (leftNode != null && leftNode.left == null && leftNode.right == null) {
            counts += leftNode.val;
        }
        // 递归遍历左右孩子
        findLeftLeaves(leftNode);
        findLeftLeaves(rightNode);
    }
}
