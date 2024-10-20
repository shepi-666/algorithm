package online.labuladong.algo.exam.bole;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-10 20:56
 * @description:
 */
public class T2Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 投票结果数组
     * @return int整型
     */
    public int minNumberDisappeared (int[] nums) {
        // write code here

        int temp = 0;
        for (int i = 1; i <= nums.length; i++) {
            temp ^= i;
        }

        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    @Test
    public void testSolution() {
        int[] nums = {2,2,3,4,4};
        System.out.println(minNumberDisappeared(nums));
        System.out.println(2 ^ 1);
    }
}
