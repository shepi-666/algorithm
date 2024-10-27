package com.programmer.carl.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 11:06
 * @description:
 */
public class T454FourSumII {

    /**
     * 四数相加II
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                if (!map.containsKey(sum)) {
                    map.put(sum, 0);
                }
                map.put(sum, map.get(sum) + 1);
            }
        }

        // 遍历 nums3 和 nums4
        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        return count;
    }

}
