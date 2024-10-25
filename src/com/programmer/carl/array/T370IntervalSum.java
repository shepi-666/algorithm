package com.programmer.carl.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 16:23
 * @description:
 */
public class T370IntervalSum {

    /**
     * 区间加法
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        int[] diff = new int[length];

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];

            diff[i] += update[2];
            if (j + 1 < length) {
                diff[j + 1] -= update[2];
            }
        }

        // 从 diff 中还原出来原始数组
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }

        return nums;
    }

    @Test
    public void testSolution() {
        int len = 10;
        int[][] updates = new int[][] {
                {1, 2, 3},
                {2, 3, -1}

        };
        System.out.println(Arrays.toString(getModifiedArray(len, updates)));
    }
}
