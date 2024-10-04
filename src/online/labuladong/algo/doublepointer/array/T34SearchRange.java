package online.labuladong.algo.doublepointer.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-04 16:05
 * @description:
 */
public class T34SearchRange {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return res;
        }

        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                // 锁定右边界
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            }
        }
        // 检查结束时.检查l是否越界或者 nums[l] == target
        if (l > nums.length - 1 || nums[l] != target) return res;
        res[0] = l;
        while (l < nums.length && nums[l] == target) {
            l++;
        }
        res[1] = l - 1;
        return res;

    }
}
