package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 21:59
 * @description:
 */
public class T538BST2SumTree {

    int curSum = 0;

    /**
     * 将 BST 转换为累加树
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {

        traverse(root);
        return root;
    }

    /**
     * 中序遍历：右孩子 -> 根节点 -> 左孩子
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.right);

        curSum += root.val;
        root.val = curSum;

        traverse(root.left);
    }
}
