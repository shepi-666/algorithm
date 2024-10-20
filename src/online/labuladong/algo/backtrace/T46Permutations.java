package online.labuladong.algo.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-08 21:45
 * @description:
 */
public class T46Permutations {

    boolean[] visited; // 访问标记
    List<List<Integer>> res;
    /**
     * 全排列问题
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        visited = new boolean[n];
        List<Integer> path = new ArrayList<>(); // 记录当前路径
        dfs(nums, path);
        return res;

    }

    private void dfs(int[] nums, List<Integer> path) {
        // 结束条件，nums元素全部在path中出现
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) { // 当前数字没有被访问过
                path.add(nums[i]); // 加入路径
                visited[i] = true; // 标记访问
                dfs(nums, path); // 进入下一层决策树
                int lastIndex = path.size() - 1;
                path.remove(lastIndex); // 取消选择
                visited[i] = false; // 取消标记

            }
        }
    }

}
