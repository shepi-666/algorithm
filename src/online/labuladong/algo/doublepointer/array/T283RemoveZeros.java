package online.labuladong.algo.doublepointer.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 11:11
 * @description:
 */
public class T283RemoveZeros {

    /**
     * 将 0 元素移动到数组末尾，不改变其他元素的值
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        // 将区间 [slow, nums.length-1]的元素置为0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void testSolution() {
        int[] nums = { 0,1,0,3,12 };
        moveZeroes(nums);
    }
}
