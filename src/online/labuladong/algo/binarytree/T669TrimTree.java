package online.labuladong.algo.binarytree;


import online.labuladong.algo.datastructure.TreeNode;
import org.junit.Test;

/**
 * @author ：Dongshaowei
 * @date ：2024/12/14 09:10
 * @description： 修剪二叉树
 */
public class T669TrimTree {


    /**
     * 使用分解问题的方式
     * 1 如果当前节点为空，直接返回为空
     * 2 如果当前节点小于目标范围
     *  直接返回 修剪之后的右孩子
     * 3 如果当前节点大于目标范围
     *  直接返回修剪之后的左孩子
     * 4 如果当前节点在目标范围
     *  获取修剪好的左孩子和右孩子
     *  构建新的BST，返回当前节点
     *
     * @param root
     * @param low
     * @param high
     * @return 当前结果返回的是什么？ 是一颗符合要求的修理好的树
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            TreeNode left = trimBST(root.left, low, high);
            TreeNode right = trimBST(root.right, low, high);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    /**
     * 修剪 BST 树
     * BST 的中序遍历是有序的
     * 中序遍历寻找范围之外的节点，需要保留父节点的信息
     * 1.中序遍历过程中找到 小 节点
     *  1.1 将父节点的左指针指向当前节点的右孩子
     *  1.2 中序遍历右孩子
     * 2.中序遍历过程中找到 大 节点
     *  2.1 将父节点的右指针指向当前节点的左孩子
     *  2.2 中序遍历左孩子
     * @param root
     * @param low
     * @param high
     * @return
     */
    @Deprecated
    public TreeNode trimBSTI(TreeNode root, int low, int high) {
        if (root == null) return null;
        TreeNode parent = null;
        return trim(parent, root, low, high);
    }

    /**
     * 中序遍历修剪节点
     * @param parent
     * @param root
     * @param low
     * @param high
     * @return
     */
    private TreeNode trim(TreeNode parent, TreeNode root, int low, int high) {
        if (root == null) return null;
        // 当前节点该怎么做？
        if (root.val >= low && root.val <= high) {
            // 遍历孩子
            TreeNode left = trim(root, root.left, low, high);
            TreeNode right = trim(root, root.right, low, high);
            root.left = left;
            root.right = right;
            return root;
        } else if (root.val < low) {

            // 遍历右孩子
            TreeNode right = trim(parent, root.right, low, high);

            // 当前节点小于目标值，将当前节点和左孩子拿走
            if (parent != null) {
                parent.left = right;
                return parent;
            } else {
                return right;
            }

        } else {
            // 遍历左孩子
            TreeNode left = trim(parent, root.left, low, high);

            // 当前节点大于目标值
            if (parent != null) {
                parent.right = left;
                return parent;
            } else {
                return left;
            }
        }
    }

    @Test
    public void testSolution() {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node1.right = node2;

        node3.right = node4;

        trimBST(node3, 3, 4);


    }





}
