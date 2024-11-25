package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-11-19 20:48
 * @description:
 */
public class T501BSTMode {

    List<Integer> ans = new ArrayList<>();

    // 初始化状态数据
    int maxCount = 1; // 最大频次
    int cur = 0; // 当前数据
    int count = 0; // 当前频次

    /**
     * 寻找 BST 中的众数
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {

        if (root == null) return null;


        // 对 root 进行中序遍历
        traverse(root);

        // 将 ans List转换为静态数组
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;


    }

    /**
     * 中序遍历
     * @param root
     * @param maxCount
     * @param cur
     * @param count
     * @return
     */
    private void traverse(TreeNode root) {

        if (root == null) return;

        traverse(root.left);

        // 中序遍历的逻辑
        if (root.val == cur) {
            // 1 更新当前数字的频次
            count++;
        } else {
            count = 1; // 复位
            cur = root.val;
        }

        // 根据count 和 maxCount的大小关系来维护结果数组
        if (count == maxCount) {
            ans.add(cur);
        } else if (count > maxCount) {
            // 更新最大频次
            ans.clear();
            ans.add(cur);
            maxCount = count;
        }


        traverse(root.right);
    }

    @Test
    public void testSolution() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
        node2.left = node3;

        int[] mode = findMode(node1);
        System.out.println(Arrays.toString(mode));

    }
}
