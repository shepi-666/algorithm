package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 16:33
 * @description:
 */
public class T889PrePostBuild {


    HashMap<Integer, Integer> postMap = new HashMap<>();
    /**
     * 根据前序遍历和后序遍历构造二叉树
     * @param preorder
     * @param postorder
     * @return
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 对postMap赋值
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }

        int preStart = 0;
        int preEnd = preorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return build(preorder, preStart, preEnd, postorder, postStart, postEnd);
    }

    /**
     * 从前序遍历和后序遍历递归构建左右子树
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        // 创建根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        if (preStart == preEnd) return root;

        // 假定前序遍历的下一个为左子树的根节点
        int lRootVal = preorder[preStart + 1];
        int lPostEnd = postMap.get(lRootVal); // 获取左根节点在后序遍历中的位置
        // 找到左子树在后序遍历中的范围
        int lPostStart = postStart;
        int counts = lPostEnd - lPostStart + 1;
        int lPreStart = preStart + 1;
        int lPreEnd = preStart + counts;

        // 获取左子树
        TreeNode leftNode = build(preorder, lPreStart, lPreEnd, postorder, lPostStart, lPostEnd);

        // 找到右子树节点的范围
        int rPreStart = lPreEnd + 1;
        int rPreEnd = preEnd;
        int rPostStart = lPostEnd + 1;
        int rPostEnd = postEnd - 1;

        // 获取右子树
        TreeNode rightNode = build(preorder, rPreStart, rPreEnd, postorder, rPostStart, rPostEnd);

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    @Test
    public void testSolution() {

        int[] preorder = { 1,2,4,5,3,6,7 };
        int[] postorder = { 4,5,2,6,7,3,1 };
        TreeNode root = constructFromPrePost(preorder, postorder);
    }

}
