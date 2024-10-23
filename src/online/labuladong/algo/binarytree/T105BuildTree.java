package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 10:22
 * @description:
 */
public class T105BuildTree {

    Map<Integer, Integer> mapIn = new HashMap<>();


    /**
     * 从前序和中序中构建树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 将中序遍历的值和索引存储到inorder中
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i], i);
        }

        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return construct(preorder, preStart, preEnd,  inorder, inStart, inEnd);

    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) return null;

        // 创建根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 创建左子树的根节点
        // 左子树在中序遍历中的范围为
        int rootIndex = mapIn.get(rootVal);
        int lInStart = inStart;
        int lInEnd = rootIndex - 1;
        int sz = lInEnd >= lInStart ? lInEnd - lInStart + 1 : 0; // 左子树节点的个数
        // 左子树在前序遍历的范围为
        int lPreStart = preStart + 1;
        int lPreEnd = preStart + sz;
        // 获取左子树的根节点
        TreeNode leftNode = construct(preorder, lPreStart, lPreEnd, inorder, lInStart, lInEnd);

        // 同理，右子树在中序遍历的节点范围为
        int rInStart = rootIndex + 1;
        int rInEnd = inEnd;
        int rPreStart = preStart + sz + 1;
        int rPreEnd = preEnd;
        TreeNode rightNode = construct(preorder, rPreStart, rPreEnd, inorder, rInStart, rInEnd);

        root.left = leftNode;
        root.right = rightNode;


        return root;
    }


}
