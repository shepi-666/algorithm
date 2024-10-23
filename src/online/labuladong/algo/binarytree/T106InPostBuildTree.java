package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 15:57
 * @description:
 */
public class T106InPostBuildTree {

    Map<Integer, Integer> inMap = new HashMap<>();
    /**
     * 根据中序和后序数组构建树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 将中序遍历的数组存储到inMap中
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return build(inorder, inStart, inEnd, postorder, postStart, postEnd);

    }

    /**
     * 递归从中序和后序遍历构建子树
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;

        // 获取根节点的值
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // 获取根节点在中序遍历中的位置
        int rootIndex = inMap.get(rootVal);

        // 获取右子节点在inorder中的范围
        int rInStart = rootIndex + 1;
        int rInEnd = inEnd;
        // 获取右子节点的数量
        int counts = rInStart > rInEnd ? 0 : rInEnd - rInStart + 1;
        // 获取右子节点在postorder中的范围
        int rPostStart = postEnd - counts;
        int rPostEnd = postEnd - 1;

        // 递归构建右子树
        TreeNode rightNode = build(inorder, rInStart, rInEnd, postorder, rPostStart, rPostEnd);

        // 获取左子节点范围
        int lInStart = inStart;
        int lInEnd = rootIndex - 1;
        // 获取左子节点在postorder中的范围
        int lPostStart = postStart;
        int lPostEnd = rPostStart - 1;
        // 递归构建左子树
        TreeNode leftNode = build(inorder, lInStart, lInEnd, postorder, lPostStart, lPostEnd);

        root.left = leftNode;
        root.right = rightNode;

        return root;

    }
}
