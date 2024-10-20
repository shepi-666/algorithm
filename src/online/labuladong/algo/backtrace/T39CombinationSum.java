package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-19 16:13
 * @description:
 */
public class T39CombinationSum {


    List<List<Integer>> resList;
    /**
     * 组合总数
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        int start = 0;

        backtrace(tempList, candidates, target, start);

        return resList;

    }

    /**
     * 回溯算法，路径和为target时跳出
     * @param tempList
     * @param candidates
     * @param target
     * @param start
     */
    private void backtrace(List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0) {
            resList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            // 将当前路径添加到list中
            tempList.add(candidates[i]);
            backtrace(tempList, candidates, target - candidates[i], i);
            // 将当前节点从路径中移出
            tempList.remove(tempList.size() - 1);
        }
    }


    @Test
    public void testSolution() {
        int[] candidates = { 2 };
        int target = 1;
        List<List<Integer>> resList = combinationSum(candidates, target);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }


}
