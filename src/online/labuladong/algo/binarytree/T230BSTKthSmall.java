package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 21:36
 * @description:
 */
public class T230BSTKthSmall {


    int count = 0;
    int target;
    int res = -1;
    /**
     * BST中第k小的数
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        target = k;
        traverse(root);
        return res;
    }


    private void traverse(TreeNode root) {
        if (root == null || count == target) return;

        traverse(root.left);

        count++;
        if (count == target) {
            res = root.val;
            return;
        }

        traverse(root.right);
    }
}
