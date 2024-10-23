package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-22 11:17
 * @description:
 */
public class T701InsertBST {

    /**
     * 往 BST 中插入值为 val 的节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return root;
    }
}
