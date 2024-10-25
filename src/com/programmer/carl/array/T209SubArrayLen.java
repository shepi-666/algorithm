package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 20:47
 * @description:
 */
public class T209SubArrayLen {

    /**
     * 长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 1; // 窗口区间为左闭右开
        int winSum = nums[0];
        while (r <= nums.length) {
            if (winSum < target && r < nums.length) {
                winSum += nums[r++];
            } else if (winSum >= target){
                minLen = Math.min(minLen, r - l);
                winSum -= nums[l++];
            } else {
                break;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 优化之后的代码
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLenI(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int minLen = nums.length + 1;
        int winSum = 0;
        while (r < nums.length) {
            winSum += nums[r++];
            while (winSum >= target) {
                minLen = Math.min(r - l, minLen);
                winSum -= nums[l++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
