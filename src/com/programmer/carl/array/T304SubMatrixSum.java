package com.programmer.carl.array;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 11:59
 * @description:
 */
public class T304SubMatrixSum {

    int[][] sumMatrix;

    public T304SubMatrixSum() {

    }

    public T304SubMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        sumMatrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumMatrix[i + 1][j + 1] = matrix[i][j] + sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };

        T304SubMatrixSum t304 = new T304SubMatrixSum(matrix);
        System.out.println(t304.sumRegion(1,2,2,4));

    }
}
