package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-10-30 15:26
 * @description:
 */
public class T107LevelTraverseII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
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
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            levelList.add(stack.pop());
        }

        return levelList;
    }
}
