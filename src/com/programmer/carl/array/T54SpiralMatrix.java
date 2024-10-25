package com.programmer.carl.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 09:53
 * @description:
 */
public class T54SpiralMatrix {

    List<Integer> resList = new ArrayList<>();
    int[] boundary;
    /**
     * 螺旋矩阵
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boundary = new int[]{0, n, 0, m};
        spiral(matrix, 0); // 0 代表从左往右遍历
        return resList;
    }

    /**
     * 螺旋遍历矩阵
     * @param matrix
     * @param direction
     */
    private void spiral(int[][] matrix, int direction) {
        if (boundary[0] == boundary[1] || boundary[2] == boundary[3]) return;


        switch (direction) {
            case 0: {
                // 从左往右遍历
                int start = boundary[0];
                int end = boundary[1];
                for (int i = start; i < end; i++) {
                    resList.add(matrix[boundary[2]][i]);
                }
                // 上边界加1
                boundary[2]++;
                // 调用从上往下遍历
                spiral(matrix, 1);
                break;
            }
            case 1: {
                // 从上往下遍历
                int start = boundary[2];
                int end = boundary[3];
                for (int i = start; i < end; i++) {
                    resList.add(matrix[i][boundary[1] - 1]);
                }
                // 右边界减1
                boundary[1]--;
                // 调用从右往左
                spiral(matrix, 2);
                break;
            }

            case 2: {
                // 从右往左
                int start = boundary[0];
                int end = boundary[1] - 1;
                for (int i = end; i >= start; i--) {
                    resList.add(matrix[boundary[3] - 1][i]);
                }
                // 下边界减1
                boundary[3]--;
                // 调用从右往左
                spiral(matrix, 3);
                break;
            }

            case 3: {
                // 从下往上遍历
                int start = boundary[2];
                int end = boundary[3] - 1;
                for (int i = end; i >= start; i--) {
                    resList.add(matrix[i][boundary[0]]);
                }
                // 左边界加1
                boundary[0]++;
                // 调用从右往左
                spiral(matrix, 0);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Test
    public void testSolution() {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}
