package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-20 17:11
 * @description:
 */
public class T543Diameter {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        // 对于每一个节点，求最大直径
        maxDepth(root);
        return maxDiameter;


    }


    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 计算最大直径
        maxDiameter = Math.max(leftMax + rightMax, maxDiameter);

        return Math.max(leftMax, rightMax) + 1;
    }
}
