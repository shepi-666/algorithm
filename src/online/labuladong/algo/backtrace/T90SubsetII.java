package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-10-18 21:29
 * @description:
 */
public class T90SubsetII {

    List<List<Integer>> resList;
    Set<String> curSets;
    /**
     * 元素重复不可重复选的子集问题
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        curSets = new HashSet<>();

        // 先排序
        Arrays.sort(nums);

        List<Integer> tempRes = new ArrayList<>();

        // 递归寻找组合函数
        for (int i = 0; i < nums.length; i++) {
            dp(i, tempRes, nums);
        }

        return resList;
    }

    /**
     * 递归函数
     * @param i 当前节点的索引
     * @param tempRes 记录临时结果的集合
     * @param nums 数组
     */
    private void dp(int i, List<Integer> tempRes, int[] nums) {
        // 递归结束条件
        if (i >= nums.length) {
            return;
        }

        boolean valid = false; // 判断当前路径是否合法

        // 将当前节点记录到路径中
        tempRes.add(nums[i]);

        // 将当前路径存储到结果集中
        if (!curSets.contains(tempRes.toString())) {
            resList.add(new ArrayList<>(tempRes));
            curSets.add(tempRes.toString());
        }

        // 子节点的选择
        for (int j = i; j < nums.length; j++) {
            dp(j + 1, tempRes, nums);
        }

        // 当前节点的标记清除
        int size = tempRes.size();
        tempRes.remove(size - 1);
    }


    public List<List<Integer>> subsetsWithDupI(int[] nums) {
        resList = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        List<Integer> tempRes = new ArrayList<>();
        dfs(0, tempRes, nums);
        return resList;
    }

    private void dfs(int i, List<Integer> tempRes, int[] nums) {
        // 前序位置，每个节点的值都是一个子集
        resList.add(new ArrayList<>(tempRes));

        // 遍历子节点
        for (int j = i; j < nums.length; j++) {
            // 剪枝：值相邻的树枝，只遍历第一条
            if (j > i && nums[j] == nums[j - 1]) continue;
            tempRes.add(nums[j]); // 将子节点加入到结果集
            dfs(j + 1, tempRes, nums);
            int size = tempRes.size();
            tempRes.remove(size - 1);
        }

    }

    @Test
    public void testSolution() {
        int[] nums = {0};
        List<List<Integer>> resList = subsetsWithDup(nums);
        for (List<Integer> res : resList) {
            System.out.println(res);
        }
    }
}
