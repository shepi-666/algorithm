package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 16:57
 * @description:
 */
public class T1904CarPooling {

    /**
     * 拼车：差分数组
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int stations = 1001; // 最多有 1001 个站点
        int[] passengers = new int[stations]; // 每个站点的人数
        int[] diff = new int[stations]; // 统计人数的变化
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += numPassengers;
            if (to< stations) {
                diff[to] -= numPassengers;
            }
        }

        // 还原乘客数量
        passengers[0] = diff[0];
        if (passengers[0] > capacity) return false;
        for (int i = 1; i < stations; i++) {
            passengers[i] = passengers[i - 1] + diff[i];
            if (passengers[i] > capacity) return false;
        }
        return true;
    }
}
