package com.programmer.carl.binarytree;


import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author ：Dongshaowei
 * @date ：2024/12/13 09:02
 * @description： 删除 BST 中的某个节点
 */
public class T450DeleteBST {

    /**
     * 删除 BST 树中的指定节点
     * 如何保证删除节点之后的二叉树还是个 BST 呢？
     * 1.查询到目标节点之后
     *      将左子树插入到右子树合适的位置
     *      将右子树插入到父节点的合适位置
     * 2.递归函数需要记录父节点，当前节点
     * @param root
     * @param key 目标节点的值
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 当前节点的父节点
        TreeNode parent = null;

        return deleteTarget(parent, root, key);

    }

    /**
     *
     * @param parent
     * @param root
     * @param key
     * @return
     */
    private TreeNode deleteTarget(TreeNode parent, TreeNode root, int key) {
        // 没有找到要删除的子节点
        if (root == null) return null;
        // 如果当前节点就是需要删除的节点
        if (root.val == key) {
            // 将左子树挪到右子树上
            TreeNode child = mergeChildren(root.left, root.right);
            // 将新孩子放在爷爷节点的合适位置，使用 root 和 parent 做对比
            if (parent == null) return child;
            else {
                if (root.val > parent.val) {
                    parent.right = child;
                } else {
                    parent.left = child;
                }
                return parent;
            }
        } else if (root.val > key) {
            // 递归删除左孩子
            deleteTarget(root, root.left, key);
        } else {
            // 递归删除右孩子
            deleteTarget(root, root.right, key);
        }
        return root;


    }

    private TreeNode mergeChildren(TreeNode left, TreeNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (right.left == null) right.left = left;
        else {
            mergeChildren(left, right.left);
        }
        return right;
    }
}
