package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 09:46
 * @description:
 */
public class T35InsertPosition {
    /**
     * 在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid;
            }
        }
        return r;
    }
}
