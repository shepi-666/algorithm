package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-07 22:49
 * @description:
 */
public class T518ChangeCoinII {

    /**
     * 零钱兑换II
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[j - 1] > i) {
                    // 表示硬币面额太大了
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 两种选择，用还是不用
                    dp[i][j] = dp[i - coins[j - 1]][j] + dp[i][j - 1]; // 用了，就可以用多次
                }
            }
        }

        return dp[amount][n];
    }

    @Test
    public void testSolution() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }


    public int changeI(int amount, int[] coins) {
        int[] dp = new int[amount];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i - coin] + dp[i];
            }
        }
        return dp[amount];
    }
}
