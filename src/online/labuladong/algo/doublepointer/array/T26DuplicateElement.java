package online.labuladong.algo.doublepointer.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 10:34
 * @description: 删除有序数组中的 重复元素
 */
public class T26DuplicateElement {


    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return ++slow;
    }


    @Test
    public void testSolution() {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));

    }

}
