package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 15:48
 * @description:
 */
public class T654MaxBT {

    /**
     * 创建最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length <= 0) return null;

        int start = 0;
        int end = nums.length - 1;
        return construct(nums, start, end);

    }

    /**
     * 递归创建最大二叉树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        // 找到最大值及其坐标
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        // 创建根节点
        TreeNode root = new TreeNode(maxVal);
        // 递归创建左右孩子节点
        TreeNode leftNode = construct(nums, start, maxIndex - 1);
        TreeNode rightNode = construct(nums, maxIndex + 1, end);

        // 构建树
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
