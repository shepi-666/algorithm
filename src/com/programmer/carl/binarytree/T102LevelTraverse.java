package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-30 15:15
 * @description:
 */
public class T102LevelTraverse {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.pollFirst();
                temp.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            levelList.add(temp);
        }
        return levelList;
    }
}
