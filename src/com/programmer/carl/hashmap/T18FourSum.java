package com.programmer.carl.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 16:40
 * @description:
 */
public class T18FourSum {

    /**
     * 四数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0 && target <= 0) return resList;
        if (nums[nums.length - 1] < 0 && target >= 0) return resList;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long remainder1 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long reminder2 = remainder1 - nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == reminder2) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        resList.add(temp);
                        r--;
                        l++;
                        // 剪枝
                        while (r >= 0 && nums[r] == nums[r + 1]) r--;
                        while (l < nums.length && nums[l] == nums[l - 1]) l++;
                    } else if (nums[l] + nums[r] < reminder2) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return resList;
    }

    @Test
    public void testSolution() {
        int[] nums = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        List<List<Integer>> resList = fourSum(nums, 294967296);
        for (List<Integer> res : resList) {
            System.out.println(res);
        }
    }
}
