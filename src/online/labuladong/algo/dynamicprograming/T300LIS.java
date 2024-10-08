package online.labuladong.algo.dynamicprograming;

/**
 * @author: DongShaowei
 * @create: 2024-10-05 15:38
 * @description:
 */
public class T300LIS {

    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxDp = 1;
        for (int i = 1; i < nums.length; i++) {
            int base = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    base = Math.max(base, dp[j]);
                }
            }
            dp[i] = Math.max(base + 1, 1);
            maxDp = Math.max(dp[i], maxDp);
        }
        return maxDp;

    }


    /**
     * 堆扑克的方法
     * @param nums
     * @return
     */
    public int lengthOfLISI(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 初始化扑克堆
        int[] piles = new int[nums.length];
        int count = 0; // 有效的堆数

        for (int i = 0; i < nums.length; i++) {
            // 取出当前的扑克牌
            int poker = nums[i];
            // 这一张扑克应当放在哪儿呢？
            // 二分法搜索左侧边界
            int l = 0, r = count;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (piles[mid] > poker) {
                    r = mid;
                } else if (piles[mid] < poker) {
                    l = mid + 1;
                } else if (piles[mid] == poker) {
                    r = mid;
                }
            }

            // 没有找到合适的牌堆，新建一堆
            if (l == count) count++;
            // 将这张牌放到牌顶
            piles[l] = poker;
        }
        return count;
    }
}
