package online.labuladong.algo.bfs;

import online.labuladong.algo.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: DongShaowei
 * @create: 2024-10-23 17:03
 * @description:
 */
public class T111MinDepth {

    /**
     * 二叉树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int minDepth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return minDepth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
