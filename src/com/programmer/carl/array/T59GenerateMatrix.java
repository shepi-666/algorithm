package com.programmer.carl.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 10:48
 * @description:
 */
public class T59GenerateMatrix {

    @Test
    public void testSolution() {
        int n = 3;
        int[][] res = generateMatrix(n);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }


    private int[][] res;
    int[] boundary;
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};

        res = new int[n][n];
        boundary = new int[]{0, n, 0, n};
        int direction = 0;
        int start = 1;
        generate(direction, start);
        return res;
    }

    /**
     * 递归模拟生成矩阵
     * @param direction
     * @param startNum
     */
    private void generate(int direction, int startNum) {
        if (boundary[0] == boundary[1] || boundary[2] == boundary[3]) {
            return;
        }

        switch (direction) {
            case 0: {
                // 从左往右遍历
                int start = boundary[0];
                int end = boundary[1];
                for (int i = start; i < end; i++) {
                    res[boundary[2]][i] = startNum++;
                }
                // 上边界加1
                boundary[2]++;
                // 调用从上往下遍历
                generate(1, startNum);
                break;
            }

            case 1: {
                // 从上往下
                int start = boundary[2];
                int end = boundary[3];
                for (int i = start; i < end; i++) {
                    res[i][boundary[1] - 1] = startNum++;
                }
                // 右边界 --
                boundary[1]--;
                // 调用从右往左
                generate(2, startNum);
                break;
            }

            case 2: {
                // 从右往左
                int start = boundary[0];
                int end = boundary[1];
                for (int i = end - 1; i >= start; i--) {
                    res[boundary[3] - 1][i] = startNum++;
                }
                // 下边界 --
                boundary[3]--;
                // 调用从右往左
                generate(3, startNum);
                break;
            }

            case 3: {
                // 从下往上
                int start = boundary[2];
                int end = boundary[3];
                for (int i = end - 1; i >= start; i--) {
                    res[i][boundary[0]] = startNum++;
                }
                // 左边界++
                boundary[0]++;
                // 调用从右往左
                generate(0, startNum);
                break;
            }

        }
    }
}
