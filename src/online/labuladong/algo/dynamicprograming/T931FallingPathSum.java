package online.labuladong.algo.dynamicprograming;

/**
 * @author: DongShaowei
 * @create: 2024-10-05 17:34
 * @description:
 */
public class T931FallingPathSum {

    /**
     * 下降路径最小和
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;

        // 初始化 dp 数组
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val1 = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int val2 = dp[i - 1][j];
                int val3 = j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                int min = Math.min(Math.min(val1, val2), val3);
                dp[i][j] = matrix[i][j] + min;
            }
        }

        // 遍历最后一行找到minDp
        int res = dp[n -1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
