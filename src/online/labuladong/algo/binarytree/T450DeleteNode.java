package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-22 11:33
 * @description:
 */
public class T450DeleteNode {

    /**
     * 删除指定的节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode parent = null;
        return delete(root, parent, key);
    }

    /**
     * 找到需要删除的节点，及其父节点和子节点
     * @param root
     * @param parent
     * @param key
     * @return
     */
    private TreeNode delete(TreeNode root, TreeNode parent, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 获取左右孩子
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode child = mergeBST(left, right);
            if (parent == null) {
                return child;
            } else {
                if (root.val < parent.val) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                return parent;
            }
        } else if (root.val < key) {
            delete(root.right, root, key);
        } else {
            delete(root.left, root, key);
        }
        return root;
    }

    /**
     * 将两颗 BST合并为一棵
     * @param left 左子树的所有值都要比右子树的小
     * @param right
     * @return
     */
    private TreeNode mergeBST(TreeNode left, TreeNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (right.left == null) {
            right.left = left;
        } else {
            mergeBST(left, right.left);
        }
        return right;
    }
}
