package com.programmer.carl.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-30 15:58
 * @description:
 */
public class T429NTreeLevel {

    /**
     * N 叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                temp.add(cur.val);
                for (Node node : cur.children) {
                    if (node != null) {
                        q.offer(node);
                    }
                }

            }
            resList.add(temp);
        }
        return resList;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node next;

    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
