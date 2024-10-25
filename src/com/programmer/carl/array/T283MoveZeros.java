package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 15:36
 * @description:
 */
public class T283MoveZeros {

    /**
     * 将 0 元素原地移动到数组末尾
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
