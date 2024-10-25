package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 11:43
 * @description:
 */
public class T303IntervalSum {

    private int[] nums;
    private int[] preSum;

    public T303IntervalSum(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right] - preSum[left] + nums[left];
    }
}
