package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;


/**
 * @author: DongShaowei
 * @create: 2024-10-22 09:55
 * @description:
 */
public class T98ValidBST {


    /**
     * 判断BST是否合法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        // 对于根节点，没有大小值的限制
        TreeNode max = null;
        TreeNode min = null;
        return valid(root, max, min);
    }

    /**
     * 判断以 root 为根节点的树是否为 BST 树
     * @param root
     * @param min 限制当前节点值的最小值
     * @param max 限制当前节点值的最大值
     * @return
     */
    private boolean valid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        // 有最小值的限制，说明当前树为右子树，右子树一定大于 min.val
        if (min != null && root.val <= min.val) return false;
        // 有最大值的限制，说明当前树为左子树，左子树一定小于 max.val
        if (max != null && root.val >= max.val) return false;

        // 左子树最大值限制为根值，右子树最小值限定为根值
        return valid(root.left, min, root) && valid(root.right, root, max);
    }


}
