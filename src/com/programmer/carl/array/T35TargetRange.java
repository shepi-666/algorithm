package com.programmer.carl.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 09:59
 * @description:
 */
public class T35TargetRange {

    /**
     * 你找出给定目标值在数组中的开始位置和结束位置。
     *
     * @param nums
     * @param target
     * @return 如果数组中不存在目标值 target，返回 [-1, -1]
     */
    public int[] searchRange(int[] nums, int target) {

        int[] range = {-1, -1};
        if (nums == null || nums.length == 0) return range;

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid;
            }
        }

        // 如果存在 target, l 应该在第一次出现的位置，否则应该是小于目标元素最大的元素的索引
        if (l >= nums.length || target != nums[l]) {
            return range;
        }
        range[0] = l;
        while (l < nums.length && nums[l] == target) {
            l++;
        }
        range[1] = --l;
        return range;

    }

    @Test
    public void testSolution() {
        int[] nums = { 5,7,7,8,8,10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }


}
