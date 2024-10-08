package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-08 10:24
 * @description:
 */
public class T174DungeonGame {
    /**
     * 地下城游戏 【不通过】
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] min = new int[m][n];
        int[][] cur = new int[m][n];
        // 初始化cur（当前血量） 和 min（最小血量）
        cur[0][0] = dungeon[0][0];
        min[0][0] = Math.min(dungeon[0][0], 0);
        for (int i = 1; i < m; i++) {
            cur[i][0] = cur[i - 1][0] + dungeon[i][0];
            min[i][0] = Math.min(min[i - 1][0],cur[i][0]);
        }
        for (int i = 1; i < n; i++) {
            cur[0][i] = cur[0][i - 1] + dungeon[0][i];
            min[0][i] = Math.min(min[0][i - 1], cur[0][i]);
        }

        // 更新 cur 和 min
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int top = Math.min(cur[i - 1][j] + dungeon[i][j], min[i - 1][j]) + cur[i - 1][j];
                int left = Math.min(cur[i][j - 1] +  dungeon[i][j], min[i][j - 1]) + cur[i][j - 1];
                if (top > left) {
                    // 选择从上面走
                    min[i][j] = Math.min(cur[i - 1][j] + dungeon[i][j], min[i - 1][j]);
                    cur[i][j] = cur[i - 1][j] + dungeon[i][j];
                } else if (top < left){
                    // 从左边走
                    min[i][j] = Math.min(cur[i][j - 1] +  dungeon[i][j], min[i][j - 1]);
                    cur[i][j] = cur[i][j - 1] +  dungeon[i][j];
                } else {
                    // 那个当前血量高，从哪个地方来
                    if (cur[i - 1][j] >= cur[i][j - 1]) {
                        // 选择从上面走
                        min[i][j] = Math.min(cur[i - 1][j] + dungeon[i][j], min[i - 1][j]);
                        cur[i][j] = cur[i - 1][j] + dungeon[i][j];
                    } else {
                        // 从左边走
                        min[i][j] = Math.min(cur[i][j - 1] +  dungeon[i][j], min[i][j - 1]);
                        cur[i][j] = cur[i][j - 1] +  dungeon[i][j];
                    }
                }
            }
        }
        return 1 - min[m - 1][n - 1];
    }

    @Test
    public void testSolution() {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }


    public int calculateMinimumHPI(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 备忘录初始化，未记录的值为-1,合法的血量应该都为[1, infinity]
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(dungeon, 0, 0);
    }

    private int[][] memo; // 备忘录，记录计算过的值

    private int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // base case
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
        }
        // 边界条件
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        // 查询备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移逻辑
        int val = Math.min(
                dp(dungeon, i + 1, j),
                dp(dungeon, i, j + 1)
        ) - dungeon[i][j];
        return val > 0 ? val : 1;
    }

    /**
     * 动态规划解决：从右下到左上更新DP table
     * @param dungeon
     * @return
     */
    public int calculateMinimumHPII(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        // 初始化最后一行和最后一列
        for (int i = m - 2; i >= 0; i--) {
            int hp = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = hp > 0 ? hp : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int hp = dp[m - 1][i + 1] - dungeon[m - 1][i];
            dp[m - 1][i] = hp > 0 ? hp : 1;;
        }

        // 状态转移
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int hp = Math.min(
                        dp[i + 1][j],
                        dp[i][j + 1]
                ) - dungeon[i][j];
                dp[i][j] = hp > 0 ? hp : 1;;
            }
        }

        return dp[0][0];

    }




}
