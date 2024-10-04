package online.labuladong.algo.doublepointer.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 11:04
 * @description:
 */
public class T27RemoveElement {


    /**
     * 移除和指定值相同的元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }
}
