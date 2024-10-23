package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-20 16:16
 * @description:
 */
public class T104MaxDepth {

    /**
     * 获取树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // 获取左子树的最大深度
        int maxLeft = maxDepth(root.left);

        // 获取右子树的最大深度
        int maxRight = maxDepth(root.right);

        // 当前子树的深度为
        return Math.max(maxLeft, maxRight) + 1;
    }
}
