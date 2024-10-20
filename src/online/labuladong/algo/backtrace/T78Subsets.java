package online.labuladong.algo.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-11 21:05
 * @description:
 */
public class T78Subsets {


    List<List<Integer>> resList;

    /**
     * 子集问题
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        resList = new ArrayList<>();
        resList.add(new ArrayList<>());

        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            dfs(i, nums, temp);
        }
        return resList;
    }

    private void dfs(int start, int[] nums, List<Integer> temp) {
        // 递归结束条件
        if (start >= nums.length) {
            resList.add(new ArrayList<>(temp));
            return;
        }
        // 将当前元素添加到路径中
        temp.add(nums[start]);
        // 遍历子树
        for (int i = start; i < nums.length; i++) {
            dfs(i + 1, nums, temp);
        }
        // 将当前元素移出
        int size = temp.size();
        temp.remove(size - 1);
    }
}
