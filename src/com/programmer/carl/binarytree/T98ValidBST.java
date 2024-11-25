package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 16:25
 * @description:
 */
public class T98ValidBST {

    /**
     * 验证是否是最BST
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        TreeNode max = null;
        TreeNode min = null;
        return valid(root, max, min);
    }

    /**
     * 递归验证是否是 BST
     * @param root
     * @param max
     * @param min
     * @return
     */
    private boolean valid(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        // 如果有限定最大值，说明是左子树，左子树大于最大值，返回false
        if (max != null && root.val > max.val) return false;

        // 有限定最小值，说明是右子树，右子树小于最小值，返回false
        if (min != null && root.val < min.val) return false;

        // 左子树最大值为 root，右子树最小值为 root
        return valid(root.left, root, min)
                && valid(root.right, max, root);
    }
}
