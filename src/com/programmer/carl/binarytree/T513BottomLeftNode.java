package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 17:35
 * @description:
 */
public class T513BottomLeftNode {

    /**
     * 找到树左下角的值
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int leftVal = -1;
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    leftVal = cur.val;
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return leftVal;
    }


    private int height;
    private int val;
    /**
     * 递归遍历
     * @param root
     * @return
     */
    public int findBottomLeftValueI(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 1);
        return val;
    }

    /**
     * 递归遍历整棵树
     * @param root
     */
    private void traverse(TreeNode root, int curHeight) {
        if (curHeight > height) {
            val = root.val;
            height = curHeight;
        }
        // 遍历左节点
        if (root.left != null) { traverse(root.left, curHeight + 1); }
        if (root.right != null) { traverse(root.left, curHeight + 1); }
    }
}
