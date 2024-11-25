package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 17:13
 * @description:
 */
public class T530BSTMinDiff {


    List<Integer> inorder = new ArrayList<>();
    /**
     * BST 中最小绝对差值
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
       // 前序遍历 BST
        traverse(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < inorder.size(); i++) {
            min = Math.min(min, inorder.get(i) - inorder.get(i - 1));
        }
        return min;
    }

    /**
     * BST 的中序遍历
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        inorder.add(root.val);

        traverse(root.right);
    }



    private int ans = Integer.MAX_VALUE;
    private int pre = -1; // 遍历的前一个节点
    /**
     * 在前序遍历的时候，更新答案
     * @param root
     * @return
     */
    public int getMinimumDifferenceI(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (pre != -1) {
            // 遍历过节点
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;

        inorder(root.right);
    }
}
