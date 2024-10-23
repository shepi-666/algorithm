package online.labuladong.algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-20 21:35
 * @description:
 */
public class T116NextRightNode {

    /**
     * 填充每个节点的下一个右侧节点指针
     * @param root 完全二叉树
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (i == sz - 1) {
                    cur.next = null;
                } else {
                    cur.next = q.peek();
                }
                // 将孩子节点放入队列
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }

        return root;
    }

    /**
     * 使用常数级的空间
     * @param root
     * @return
     */
    public Node connectI(Node root) {

        traverse(root);
        return root;
    }

    private void traverse(Node root) {
        if (root == null) return;

        // 获取左子树
        root.left.next = root.right;
        if (root.next == null) {
            root.right.next = null;
        } else {
            root.right.next = root.next.left;
        }

        traverse(root.left);
        traverse(root.right);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
