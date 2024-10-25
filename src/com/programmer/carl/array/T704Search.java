package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 09:38
 * @description:
 */
public class T704Search {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
