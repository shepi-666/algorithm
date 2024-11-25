package com.programmer.carl.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-30 16:23
 * @description:
 */
public class T116NextPointerTree {

    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (i == sz - 1) {
                    cur.next = null;
                } else {
                    cur.next = q.peek();
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return root;
    }


    public Node connectII(Node root) {
        if (root == null) return null;

        Node head = root;

        // 循环遍历每一层链表
        while (head != null) {
            // 构建下一层的链表
            Node dummy = new Node();
            Node temp = dummy;

            // 遍历当前链表
            Node cur = head;
            while (cur != null) {
                if (cur.left != null) {
                    temp.next = cur.left; // 构建子节点链表
                    temp = temp.next; // 指针移动
                }
                if (cur.right != null) {
                    temp.next = cur.right;
                    temp = temp.next;
                }
                cur = cur.next;
            }
            // 移动到下一层的头结点处
            head = dummy.next;
        }
        return root;
    }
}
