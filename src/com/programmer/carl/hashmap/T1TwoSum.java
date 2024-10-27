package com.programmer.carl.hashmap;

import java.util.HashMap;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 10:52
 * @description:
 */
public class T1TwoSum {

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}
