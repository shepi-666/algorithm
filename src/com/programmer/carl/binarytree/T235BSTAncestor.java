package com.programmer.carl.binarytree;


import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author ：dongshaowei
 * @date ：2024/12/13 08:36
 * @description：TODO
 */
public class T235BSTAncestor {

    /**
     * BST 树的最近公共祖先
     * 1.当前节点的值在两个值中间 返回当前节点
     * 2.当前节点值大于两个值，返回左孩子
     * 3.当前节点的值小于两个值，返回右孩子
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
