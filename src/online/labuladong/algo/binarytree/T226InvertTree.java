package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-20 21:29
 * @description:
 */
public class T226InvertTree {

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 获得反转之后的左子树
        TreeNode leftNode = invertTree(root.left);

        // 获得翻转之后的右子树
        TreeNode rightNode = invertTree(root.right);

        // 将左右子树交换位置

        root.left = rightNode;
        root.right = leftNode;

        // 返回根节点
        return root;


    }
}
