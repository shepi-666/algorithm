package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-07 21:33
 * @description:
 */
public class T416SameSubSum {

    /**
     * 分割等和子集
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false; // 和为奇数
        int subSum = sum / 2;
        int n = nums.length;

        int[][] dp = new int[subSum + 1][n + 1]; // 当前和为 subSum下，选择第 i 个数字能达到的最大的重量
        for (int i = 1; i <= subSum; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums[j - 1] > subSum) return false;
                if (i - nums[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1]; // 不放
                } else {
                    dp[i][j] = Math.max(
                            dp[i][j - 1], // 不放
                            dp[i - nums[j - 1]][j - 1] + nums[j - 1] // 放

                    );
                }

            }
        }

        // 检查最后一行是否有两个 subSum
        int countSum = 0;
        for (int num : dp[subSum]) {
            if (num == subSum) {
               countSum++;
            }
        }

        return countSum >= 2;
    }


    @Test
    public void testSolution() {
        int[] nums = {1,5,11,5};
        System.out.println(canPartitionII(nums));
    }

    public boolean canPartitionI(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int subSum = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[subSum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }


        for (int i = 1; i <= subSum; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums[j - 1] > subSum) {
                    // 当前数字大于 子集和
                    return false;
                }
                if (nums[j - i] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1]; // 不放 或者 放
                }
            }
        }

        return dp[subSum][n];
    }

    /**
     * 空间优化版本
     * @param nums
     * @return
     */
    public boolean canPartitionII(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int subSum = sum / 2;
        int n = nums.length;

        boolean[] dp = new boolean[subSum + 1];
        dp[0] = true;


        for (int i = 0; i < n; i++) {
            for (int j = subSum; j >= 0; j--) { // 从后往前遍历，每个数字只能用一次，以免之前的结果影响其他的结果
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]]; // 不放或者放
                }
            }
        }

        return dp[subSum];
    }

}
