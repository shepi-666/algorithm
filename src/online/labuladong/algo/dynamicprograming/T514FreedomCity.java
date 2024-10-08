package online.labuladong.algo.dynamicprograming;

import sun.awt.util.IdentityLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-08 16:56
 * @description:
 */
public class T514FreedomCity {

    HashMap<Character, List<Integer>> indexList = new HashMap<>(); // 记录某个char的索引位置
    // 备忘录
    int[][] memo;

    /**
     * 自由之路
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();

        // 备忘录初始化为0
        memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, 0);
        }
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!indexList.containsKey(c)) {
                indexList.put(c, new ArrayList<>());
            }
            indexList.get(c).add(i); // 添加索引
        }

        // 从第1个字符开始输入，圆盘位置在12点方向
        return dp(ring, 0, key, 0);
    }

    private int dp(String ring, int i, String key, int j) {

        if (j == key.length()) return 0; // 递归结束条件

        if (memo[i][j] != 0) return memo[i][j]; // 查找备忘录

        int n = ring.length();
        int res = Integer.MAX_VALUE;
        for (int k : indexList.get(key.charAt(j))) { // 当前字符在ring字符串的位置
            // 拨动圆盘的次数
            int counts = Math.abs(k - i); // i 到 k 之间的距离
            // 选择顺时针拨动还是逆时针
            counts = Math.min(counts, n - counts); //谁短听谁的
            // 继续输入下一个字符
            int remainders = dp(ring, k, key, j + 1);
            res = Math.min(res,  1 + counts + remainders); // 选择整体步数较小的
        }
        memo[i][j] = res;

        return res;
    }
}
