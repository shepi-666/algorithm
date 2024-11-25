package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-11-01 15:29
 * @description:
 */
public class T106BuildTreeFromInPost {

    Map<Integer, Integer> inMap = new HashMap<>();
    /**
     * 从中序和后序遍历数组中构建树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 初始化存储中序遍历索引和值的map
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
     * 递归构建树
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
        // 取出根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);

        // 获取左子树的数量
        int leftCounts = rootIndex - inStart;
        // 获取左子树在后续遍历的范围
        int lPostStart = postStart;
        int lPostEnd = postStart + leftCounts - 1;
        // 左子树在中序遍历的范围
        int lInStart = inStart;
        int lInEnd = rootIndex - 1;

        // 递归创建左子树
        TreeNode leftNode = build(inorder, lInStart, lInEnd, postorder, lPostStart, lPostEnd);

        // 获取右子树在中序和后序的范围
        int rInStart = rootIndex + 1;
        int rInEnd = inEnd;
        int rPostStart = lPostEnd + 1;
        int rPostEnd = postEnd - 1;

        // 递归创建右子树
        TreeNode rightNode = build(inorder, rInStart, rInEnd, postorder, rPostStart, rPostEnd);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
