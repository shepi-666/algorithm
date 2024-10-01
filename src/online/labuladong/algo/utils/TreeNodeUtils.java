package online.labuladong.algo.utils;

import online.labuladong.algo.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-01 17:13
 * @description: 二叉树的遍历
 */
public class TreeNodeUtils {

    /**
     * 遍历
     * @param root
     * @return
     */
    public static final List<Integer> traverse(TreeNode root, Traverse t) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return null;
        switch (t) {
            case PREFIX: prefixTraverse(root, resList); break;
            case INFIX: infixTraverse(root, resList); break;
            case POSTFIX: postfixTraverse(root, resList); break;
            case LEVEL: levelTraverse(root, resList);
            default: throw new RuntimeException("遍历类型出错");
        }
        return resList;
    }

    /**
     * 后序遍历
     * @param root
     * @param resList
     */
    private static void postfixTraverse(TreeNode root, List<Integer> resList) {
        if (root == null) return;

        postfixTraverse(root.left, resList);

        postfixTraverse(root.right, resList);

        resList.add(root.val);
    }

    /**
     * 中序遍历
     * @param root
     * @param resList
     */
    private static void infixTraverse(TreeNode root, List<Integer> resList) {
        if (root == null) return;

        infixTraverse(root.left, resList);

        resList.add(root.val);

        infixTraverse(root.right, resList);
    }

    /**
     * 前序遍历
     * @param root
     * @param resList
     */
    private static void prefixTraverse(TreeNode root, List<Integer> resList) {
        if (root == null) return;
        resList.add(root.val);
        prefixTraverse(root.left, resList);
        prefixTraverse(root.right, resList);
    }


    /**
     * 二叉树的层序遍历
     * @param root
     * @param resList
     */
    public static void levelTraverse(TreeNode root, List<Integer> resList) {
        if (root == null) return;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            // 访问当前节点
            resList.add(curNode.val);

            // 将当前节点的左右孩子加入队列中
            if (curNode.left != null) {
                nodeQueue.add(curNode.left);
            }

            if (curNode.right != null) {
                nodeQueue.add(curNode.right);
            }
        }
    }


    @Test
    public void testPrefix() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        Traverse t = Traverse.INFIX;

        List<Integer> list = traverse(root, t);
        System.out.println(list.toString());
    }
}
