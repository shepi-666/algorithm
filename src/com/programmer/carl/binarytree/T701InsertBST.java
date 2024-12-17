package com.programmer.carl.binarytree;


import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author ：
 * @date ：2024/12/13 08:48
 * @description：
 */
public class T701InsertBST {

    /**
     * BST 的插入操作
     * 1.如果 root.val 大于 val
     *      左子树为空，则将其放在左子树
     *      不为空，则递归将其往左子树中插入
     * 2.如果 root.val 小于 val，
     *      右子树为空，则将其放入到右子树
     *      不为空，则递归将其往右子树中插入
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // 左子树的操作
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        }

        // 右子树的操作
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }

        return root;

    }
}
