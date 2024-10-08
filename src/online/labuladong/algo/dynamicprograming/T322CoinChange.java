package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-05 09:53
 * @description:
 */
public class T322CoinChange {

    /**
     * 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        // 首先给零钱排序
        Arrays.sort(coins);
        int remainders = amount; // 一次兑换成功后剩余的
        int count = 0; // 统计硬币的数量
        int index = coins.length - 1; // 表示硬币面额


        while (remainders != 0) {
            if (remainders < coins[0]) { // 没有更小的纸币了
                return -1;
            }
            while (index >= 0 && remainders - coins[index] >= 0) {
                remainders -= coins[index];
                count++;
            }
            index--;
        }
        return count;
    }


    @Test
    public void testSolution() {
        int[] coins = {1,2147483647};
        int amount = 2;
        System.out.println(coinChangeII(coins, amount));
    }


    /**
     * 使用递归方式解决
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeI(int[] coins, int amount) {

        return dp(coins, amount);
    }

    /**
     * 自顶而下递归求解
     * @param coins
     * @param remainders
     * @return
     */
    private int dp(int[] coins, int remainders) {
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            res = Math.min(res, 1 + dp(coins, remainders - coin));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * 使用迭代的方式，自底向上更新
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeII(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        int minCoin = Integer.MAX_VALUE;
        int maxCoin = 0;
        for (int coin : coins) {
            minCoin = Math.min(coin, minCoin);
            maxCoin = Math.max(coin, maxCoin);
        }

        // 计算出最多出现几轮
        int counts = amount / minCoin + 1;
        int count = 0;


        while (count < counts) { // 这层循环可以省略
            for (int i = amount; i >= minCoin * count; i--) {
                if (dp[i] != 0) {
                    for (int coin : coins) {
                        if (i + coin <= amount && i + coin > 0) {
                            dp[i + coin] = dp[i + coin] == 0 ? 1 + dp[i] : Math.min(1 + dp[i], dp[i + coin]);
                        }
                    }
                }
            }
            count++;
            if (dp[amount] != 0) return dp[amount];
        }
        return -1;
    }

    public int coinChangeIII(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // 初始化dp数组
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }

        // 自底向上更新dp数组
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount ? -1 : dp[amount];
    }

}
