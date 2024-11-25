package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 15:07
 * @description:
 */
public class T112PathSum {

    private boolean available = false;
    /**
     * 是否存在路径和为 sum 的路径
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int curSum = 0;
        backtrace(root, curSum, targetSum);
        return available;
    }

    /**
     * 回溯 判断路径和是否为 targetSum
     * @param root
     * @param curSum
     */
    private void backtrace(TreeNode root, int curSum, int targetSum) {
        if (available || root == null) return;
        // 将当前值添加到路径中
        curSum += root.val;
        // 当前是叶子节点
        if (root.left == null && root.right == null ) {
            if (curSum == targetSum) {
                this.available = true; // 标记为置为 true
            }
            return;
        }
        // 遍历左右叶子节点
        if (root.left != null) {
            backtrace(root.left, curSum, targetSum);
        }
        if (root.right != null) {
            backtrace(root.right, curSum, targetSum);
        }
        // 将当前节点移出路径
        curSum -= root.val;
    }

}
