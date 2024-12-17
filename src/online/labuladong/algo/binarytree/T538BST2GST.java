package online.labuladong.algo.binarytree;


import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author ：Dongshaowei
 * @date ：2024/12/17 08:46
 * @description：将 BST 转换为累加树
 */
public class T538BST2GST {

    private int curSum = 0;

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
     * 中序遍历：右 - 中 - 左
     * @param root
     * @param curSum
     * @return
     */
    private void traverse(TreeNode root) {

        if (root == null) return ;

        traverse(root.right);

        curSum += root.val;

        root.val = curSum;

        traverse(root.left);

    }
}
