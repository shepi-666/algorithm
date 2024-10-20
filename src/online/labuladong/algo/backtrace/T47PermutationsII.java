package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-19 15:40
 * @description:
 */
public class T47PermutationsII {


    List<List<Integer>> resList;
    boolean[] isVisited;
    /**
     * 全排列，元素可以重复，不能重复选
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        resList = new ArrayList<>();
        int n = nums.length;
        isVisited = new boolean[n];
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, tempList);
        return resList;
    }

    /**
     * 回溯算法
     * @param nums
     * @param tempList
     */
    private void backtrace(int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            // 已经找到了一个全排列
            resList.add(new ArrayList<>(tempList));
            return;
        }

        int preNum = 100; // 定义上一个访问的数字
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i] && nums[i] != preNum) {
                isVisited[i] = true; // 访问标记
                tempList.add(nums[i]);
                backtrace(nums, tempList);
                int size = tempList.size();
                tempList.remove(size - 1);
                isVisited[i] = false;
                preNum = nums[i]; // 记录当前访问的数字
            }
        }

    }

    @Test
    public void testSolution() {
        int[] nums = {3,3,0,3};
        List<List<Integer>> resList = permuteUnique(nums);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }
}
