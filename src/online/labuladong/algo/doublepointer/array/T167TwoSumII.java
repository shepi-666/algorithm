package online.labuladong.algo.doublepointer.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-04 16:22
 * @description:
 */
public class T167TwoSumII {


    /**
     * 两数之和：输入为有序数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int[] res = {1, numbers.length};

        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
