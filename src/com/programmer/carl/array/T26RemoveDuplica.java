package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 15:28
 * @description:
 */
public class T26RemoveDuplica {

    /**
     * 删除重复的元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) return nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }
}
