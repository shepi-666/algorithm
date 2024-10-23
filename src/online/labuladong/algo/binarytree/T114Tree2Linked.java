package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author: DongShaowei
 * @create: 2024-10-20 22:16
 * @description:
 */
public class T114Tree2Linked {


    Queue<TreeNode> q = new LinkedList<>();
    /**
     * 将二叉树根据前序遍历的方式连接成为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        preorder(root);

        // 遍历队列，重新构建链表
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            cur.left = null;
            cur.right = q.peek();
        }

    }

    /**
     * 前序遍历的方式添加节点到队列中
     * @param root
     */
    private void preorder(TreeNode root) {
        if (root == null) return;

        q.offer(root);

        preorder(root.left);
        preorder(root.right);
    }


    /**
     * 使用分解问题的思想，解决二叉树重构链表
     * @param root
     */
    public void flattenI(TreeNode root) {

        tree2linked(root);

    }

    public TreeNode tree2linked(TreeNode root) {
        if (root == null || root.left == null) return root;

        // 左子树链表化
        TreeNode left = tree2linked(root.left);

        // 右子树链表化
        TreeNode right = tree2linked(root.right);

        // 找到左子树的尾结点
        if (left != null) {
            TreeNode leftTail = left;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }

            // 将当前节点的右指针指向左子树
            root.right = left;
            // 当前节点的左指针置空
            root.left = null;
            // 当前左指针尾部指向右子树
            leftTail.right = right;

        }

        return root;
    }

    public void flattenII(TreeNode root) {
        if (root == null) return;

        // 将左右子树变为链表
        flattenII(root.left);
        flattenII(root.right);

        // 获取左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        // 获取左子树的尾结点
        TreeNode p = left;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;


    }
}
