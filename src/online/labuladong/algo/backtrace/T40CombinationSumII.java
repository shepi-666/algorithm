package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-19 10:31
 * @description:
 */
public class T40CombinationSumII {

    List<List<Integer>> resList = new ArrayList<>();

    /**
     * 组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || candidates[0] > target) {
            return resList;
        }
        int start = 0;
        List<Integer> tempRes = new ArrayList<>();
        dfs(candidates, target, start, tempRes);
        return resList;
    }

    /**
     * 深度有限搜索函数
     * @param candidates 数组
     * @param target 目标数
     * @param start 开始索引
     * @param tempRes 存放临时结果
     */
    private void dfs(int[] candidates, int target, int start, List<Integer> tempRes) {
        if (target == 0) {
            resList.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 如果当前nums[i] > target, 直接跳出循环
            if (candidates[i] > target) {
                break;
            }
            // 需要剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 将当前的值加入临时结果列表
            tempRes.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, tempRes);
            // 移除元素
            int size = tempRes.size();
            tempRes.remove(size - 1);
        }

    }

    @Test
    public void testSolution() {
        int[] candidates = { 10,1,2,7,6,1,5 };
        int target = 8;
        List<List<Integer>> resList = combinationSum2(candidates, target);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }
}
