package com.programmer.carl.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 16:37
 * @description:
 */
public class T977SortedSquares {

    /**
     * 有序数组的平方
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int minAbs = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < minAbs) {
                minAbs = Math.abs(nums[i]);
                start = i;
            }
        }

        int l = start;
        int r = start + 1;
        int[] res = new int[nums.length];
        int count = 0;
        while (l >= 0 && r < nums.length) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[count++] = (int) Math.pow(nums[r++], 2);
            } else {
                res[count++] = (int) Math.pow(nums[l--], 2);
            }
        }
        if (l == -1) {
            while (r < nums.length) {
                res[count++] = (int) Math.pow(nums[r++], 2);
            }
        } else if (r == nums.length) {
            while (l >= 0) {
                res[count++] = (int) Math.pow(nums[l--], 2);
            }
        }
        return res;

    }

    @Test
    public void testSolution() {
        int[] nums = { -5,-3,-2,-1 };
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    /**
     * 从两端开始，左右指针
     * @param nums
     * @return
     */
    public int[] sortedSquaresI(int[] nums) {
        int[] res = new int[nums.length];
        int tail = nums.length - 1;
        int l = 0;
        int r = tail;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[tail--] = nums[l] * nums[l];
                l++;
            } else {
                res[tail--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
