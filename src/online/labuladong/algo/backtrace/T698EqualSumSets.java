package online.labuladong.algo.backtrace;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author: DongShaowei
 * @create: 2024-10-19 22:15
 * @description:
 */
public class T698EqualSumSets {

    /**
     * 划分为 K 个相等的子集，从数字的视角出发
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        // 桶集合，记录每个桶的和
        int[] buckets = new int[k];
        // 理论上每个桶集合中的数字和
        int target = sum / k;

        // 将数组从大到小排列
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        // 穷举，判断是否能够划分为 target 子集
        return backtrace(nums, 0, buckets, target);
    }

    /**
     * 递归判断是否可以拆分
     * @param nums
     * @param i
     * @param buckets
     * @param target 每个桶的目标和
     * @return
     */
    private boolean backtrace(int[] nums, int i, int[] buckets, int target) {
        if (i == nums.length) {
            // 遍历检查所有桶中的数字之和是否为 target
            for (int j = 0; j < buckets.length; j++) {
                if (buckets[j] != target) {
                    return false;
                }
            }
            return true;
        }

        // 穷举 nums[i] 可能放到的桶中
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] + nums[i] > target) {
                // 这个桶桶不能放这个数字
                continue;
            }
            buckets[j] += nums[i];
            // 穷举递归下一个数字的选择
            if (backtrace(nums, i + 1, buckets, target)) {
                return true;
            }
            // 撤销数字的选择
            buckets[j] -= nums[i];
        }

        // 放到哪个桶中都是不可以的
        return false;
    }

    @Test
    public void testSolution() {
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int target = 4;
        System.out.println(canPartitionKSubsetsII(nums, target));
    }

    /**
     * 从每个桶的视角出发
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsetsII(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        // 每个桶的目标数字
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return bucketTrace(k, 0, nums, 0, used, target);
    }

    /**
     * 回溯函数的含义：
     * 第 k 号桶正在考虑要不要将 nums[i] 这个数字放入到桶中。
     * 目前，k 号桶中已经装了 curSum 的数字，used 表示已经装入桶中的数字
     * target 表示 curSum 要达到的目标和
     * @param k 桶的编号
     * @param curSum 当前桶的数字和
     * @param nums 数组
     * @param i 当前数字索引
     * @param used 标记使用的数字
     * @param target 目标和
     * @return
     */
    private boolean bucketTrace(int k, int curSum, int[] nums, int i, boolean[] used, int target) {
        if (k == 0) {
            // 所有的桶都被装满了，因为我们是装了一个桶之后才装下一个桶的，确保了每个桶都是目标和
            return true;
        }

        if (curSum == target) {
            return bucketTrace(k - 1, 0, nums, 0, used, target);
        }

        // 从start 开始向后探查有效的 nums[i] 装入桶中
        for (int j = i; j < nums.length; j++) {
            // 剪枝
            if (used[j]) {
                continue;
            }
            if (nums[j] + curSum > target) {
                continue; // 桶里面装不下
            }
            // 将当前数字装入桶中
            used[j] = true;
            curSum += nums[j];
            // 递归穷举下一个数字是否应该装进桶中
            if (bucketTrace(k, curSum, nums, j + 1, used, target)) {
                return true;
            }

            // 撤销选择
            used[j] = false;
            curSum -= nums[j];
        }
        return false;
    }


    /**
     * 带有备忘录的解法：从桶的视角出发
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsetsI(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        // 每个桶的目标数字
        int target = sum / k;
        int used = 0;
        return dfs(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();
    private boolean dfs(int k, int curSum, int[] nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }

        if (curSum == target) {
            // 递归下一个桶
            boolean res = dfs(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            return memo.get(used); // 避免冗余计算
        }

        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                // 判断当前数字nums[i]是否被使用过
                continue;
            }
            if (nums[i] + curSum > target) continue;

            // 做选择
            used |= 1 << i;
            curSum += nums[i];
            if (dfs(k, curSum, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i;
            curSum -= nums[i];
        }
        return false;
    }


}
