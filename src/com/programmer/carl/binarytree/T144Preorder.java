package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-30 15:07
 * @description:
 */
public class T144Preorder {

    List<Integer> resList = new ArrayList<>();

    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return resList;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        resList.add(root.val);

        traverse(root.left);
        traverse(root.right);
    }
}
