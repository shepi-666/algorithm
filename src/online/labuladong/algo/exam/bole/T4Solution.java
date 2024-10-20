package online.labuladong.algo.exam.bole;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-10 21:46
 * @description:
 */
public class T4Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最大的子数组
     * 输入的变量是一个一维数组，数组中的元素都是int类型。
     * @param arr int整型一维数组 一维整型数组
     * @return int整型
     */
    public int maximumSum (int[] arr) {
        // write code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int min = arr[0];
        boolean deleted = false;

        for (int i = 1; i < n; i++) {
            if (min > arr[i]) {
                if (arr[i] >= 0) {
                    dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                } else {
                    // 需要删除，并且删除当前元素
                    if (!deleted) {
                        dp[i] = Math.max(dp[i - 1], arr[i]);
                        deleted = true;
                    } else {
                        dp[i] = Math.max(dp[i - 1] + min - arr[i], arr[i]);
                    }

                }
                min = arr[i];
            } else {
                // 不需要删除
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            }
        }
        return dp[n - 1];
    }

    @Test
    public void testSolution() {
        int[] nums = {2, -1, 0 ,4};
        System.out.println(maximumSum(nums));
    }

}
