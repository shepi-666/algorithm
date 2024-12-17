package online.labuladong.algo.binarytree;


import online.labuladong.algo.datastructure.TreeNode;

/**
 * @author ：Dongshaowei
 * @date ：2024/12/16 08:58
 * @description：
 */
public class T108Array2BST {

    /**
     * 将有序数组转换为平衡搜索二叉树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int start = 0;
        int end = nums.length - 1;
        int rootIndex = start + (end - start) / 2;
        return transform(nums, start, end, rootIndex);
    }

    /**
     * 将数组转换为二叉树
     * @param nums
     * @param start
     * @param end
     * @param rootIndex
     * @return
     */
    private TreeNode transform(int[] nums, int start, int end, int rootIndex) {
        if (rootIndex < start || rootIndex > end) return null;
        TreeNode root = new TreeNode(nums[rootIndex]);
        TreeNode left = transform(nums, start, rootIndex - 1, start + (rootIndex - 1 - start) / 2);
        TreeNode right = transform(nums, rootIndex + 1, end, rootIndex + 1 + (end - rootIndex - 1) / 2);
        root.left = left;
        root.right = right;
        return root;
    }

}
