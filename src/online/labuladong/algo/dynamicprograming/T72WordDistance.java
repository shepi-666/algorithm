package online.labuladong.algo.dynamicprograming;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-06 09:53
 * @description:
 */
public class T72WordDistance {

    int[][] memo;


    /**
     * 两个单词之间的最小编辑距离[递归解法]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return dp(word1, m, word2, n);
    }

    private int dp(String word1, int m, String word2, int n) {
        if (m == -1) return n + 1;
        if (n == -1) return m + 1;

        if (word1.charAt(m) == word2.charAt(n)) {
            return dp(word1, m - 1, word2, n - 1);
        } else {
            return Math.min(
                    dp(word1, m - 1, word2, n) + 1, // 删除
                    Math.min(
                            dp(word1, m, word2, n - 1) + 1, // 添加
                            dp(word1, m - 1, word2, n - 1) + 1 // 修改
                    )
            );
        }
    }

    public int minDistanceI(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 初始化memo
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // 表示(i, j)结尾的最短编辑距离没有计算出来
        }
        return dpWithMemo(word1, m, word2, n);


    }

    private int dpWithMemo(String word1, int i, String word2, int j) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (memo[i][j] != -1) return memo[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dpWithMemo(word1, i -1, word2, j - 1);
        } else {
            memo[i][j] = Math.min(
                    dpWithMemo(word1, i, word2, j - 1) + 1, // 插入
                    Math.min(
                            dpWithMemo(word1, i - 1, word2, j) + 1, // 删除
                            dpWithMemo(word1, i - 1, word2, j - 1) + 1 // 替换
                    )
            );
        }
        return memo[i][j];
    }


    public int minDistanceII(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 初始化dp table
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一行
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        // 初始化第一列
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        // 从左上往右下更新 dp table
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 当前字符相同
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + 1, // 替换
                            Math.min(
                                    dp[i - 1][j] + 1, // 删除
                                    dp[i][j - 1] + 1 // 插入
                            )
                    );
                }
            }
        }
        return dp[m][n];

    }

}
