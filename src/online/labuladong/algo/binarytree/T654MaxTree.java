package online.labuladong.algo.binarytree;

import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author: DongShaowei
 * @create: 2024-10-21 10:01
 * @description:
 */
public class T654MaxTree {

    /**
     * 创建最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(nums, 0, nums.length - 1);

    }

    /**
     * 递归构建最大子树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode construct(int[] nums, int start, int end) {

        if (start > end) return null;

        // 寻找当前范围最大值
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        // 创建当前节点
        TreeNode cur = new TreeNode(maxVal);

        // 递归构建左子树
        TreeNode left = construct(nums, start, maxIndex - 1);
        // 递归构建右子树
        TreeNode right = construct(nums, maxIndex + 1, end);

        cur.left = left;
        cur.right = right;

        return cur;

    }
}
