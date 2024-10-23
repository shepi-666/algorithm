package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-20 16:41
 * @description:
 */
public class T144Preorder {

    List<Integer> resList = new ArrayList<>();
    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        resList = new ArrayList<>();

        traverse(root);

        return resList;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        // 前序位置
        resList.add(root.val);

        traverse(root.left);

        traverse(root.right);
    }
}
