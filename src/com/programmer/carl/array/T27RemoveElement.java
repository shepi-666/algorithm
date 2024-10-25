package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 15:17
 * @description:
 */
public class T27RemoveElement {

    /**
     * 原地移除指定的元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
