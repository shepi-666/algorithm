package com.programmer.carl.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 16:16
 * @description:
 */
public class T15ThreeSum {

    /**
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        k--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        j++;
                        k--;
                        res.add(temp);
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;

    }

    @Test
    public void testSolution() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> resList = threeSum(nums);
        for (List<Integer> res : resList) {
            System.out.println(res);
        }
    }
}
