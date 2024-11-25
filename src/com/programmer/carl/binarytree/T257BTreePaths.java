package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-31 16:42
 * @description:
 */
public class T257BTreePaths {


    List<String> paths = new ArrayList<>();
    /**
     * 二叉树的所有路径
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return paths;
        List<Integer> path = new ArrayList<>(); // 记录路径
        backtrace(root, path);
        return paths;
    }

    /**
     * 回溯的方式获得二叉树的所有路径
     * @param root
     * @param
     */
    private void backtrace(TreeNode root, List<Integer> path) {
        // 首先将当前节点添加到路径中
       path.add(root.val);
        // 如果当前节点没有孩子节点，说明到头了，是一条路径
        if (root.left == null && root.right == null) {
            String res = toPath(path);
            // 将路径加入到结果集合中
            paths.add(res);
        }
        if (root.left != null) {
            // 遍历左孩子
            backtrace(root.left, path);
        }
        if (root.right != null) {
            // 遍历右孩子
            backtrace(root.right, path);
        }
        // 将当前节点从路径中取消
        path.remove(path.size() - 1);
    }

    private String toPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int num : path) {
            sb.append(num).append("->");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
