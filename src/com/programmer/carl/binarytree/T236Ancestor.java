package com.programmer.carl.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: DongShaowei
 * @create: 2024-11-20 20:14
 * @description:
 */
public class T236Ancestor {

    private List<TreeNode> pParents = new ArrayList<>();
    private List<TreeNode> qParents = new ArrayList<>();

    private boolean findP  = false;
    private boolean findQ = false;

    /**
     * 二叉树两个节点的公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> tempP = new ArrayList<>(); // P临时路径
        List<TreeNode> tempQ = new ArrayList<>(); // Q临时路径

        // DFS分别寻找两个节点的祖先列表
        findAncestors(root, p, q, tempP, tempQ);

        Set<TreeNode> parentSet = new HashSet<>(qParents);
        // 从后往前遍历，寻找最近的公共根节点
        for (int i = pParents.size() - 1; i >= 0; i--) {
            if (parentSet.contains(pParents.get(i))) {
                return pParents.get(i);
            }
        }
        return root;
    }

    private void findAncestors(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> tempP, List<TreeNode> tempQ) {
        if (root == null || (findP &&  findQ)) return;

        // 树的前序遍历，将当前节点装入到临时路径中
        if (tempP != null) {
            tempP.add(root);
        }
        if (tempQ != null) {
            tempQ.add(root);
        }

        // 判断当前节点和目标节点的关系
        if (root == p) {
            findP = true;
            // 将临时路径赋值给pParents
            pParents = new ArrayList<>(tempP);
            tempP = null;
        }

        if (root == q) {
            findQ = true;
            qParents = new ArrayList<>(tempQ);
            tempQ = null;
        }

        // 分别往左孩子，右孩子去寻找目标节点
        findAncestors(root.left, p, q, tempP, tempQ);
        findAncestors(root.right, p, q, tempP, tempQ);

        // 将当前节点从路径中删除
        if (tempP != null) {
            tempP.remove(tempP.size() - 1);
        }
        if (tempQ != null) {
            tempQ.remove(tempQ.size() - 1);
        }


    }


    /**
     * 以分解的问题的思路解决
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // 从左边子树找到的最近的公共祖先
        TreeNode leftParent = lowestCommonAncestor(root.left, p, q);
        // 从右子树中找到最近的公共祖先
        TreeNode rightParent = lowestCommonAncestor(root.right, p, q);

        if (leftParent == null) return rightParent;
        if (rightParent == null) return leftParent;
        return root;
    }
}
