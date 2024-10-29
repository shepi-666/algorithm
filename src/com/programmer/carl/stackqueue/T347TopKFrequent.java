package com.programmer.carl.stackqueue;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 18:13
 * @description:
 */
public class T347TopKFrequent {

    /**
     * 前 k 个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<int[]> frequency = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] pairs = new int[2];
            pairs[0] = entry.getKey();
            pairs[1] = entry.getValue();
            frequency.add(pairs);
        }
        Collections.sort(frequency, (o1, o2) -> o2[1] - o1[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = frequency.get(i)[0];
        }
        return res;
    }

    /**
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[k];

        // 找到数组中的最大值和最小值
        for (int i : nums) {
            max = Math.max(i, max); // 更新最大值
            min = Math.min(i, min); // 更新最小值
        }

        // 创建一个桶数组，用于记录每个数字出现的频率
        int[] buckets = new int[max - min + 1];
        for (int num : nums) {
            buckets[num - min]++; // 将数字映射到桶数组中，并增加频率
        }

        // 找到桶数组中的最大频率
        int maxF = 0;
        for (int bucket : buckets) {
            maxF = Math.max(bucket, maxF); // 更新最大频率
        }

        int index = 0; // 结果数组的索引
        // 找到出现频率最高的 k 个数字
        while (index < k) {
            for (int i = 0; i < buckets.length; i++) {
                if (maxF == buckets[i]) {
                    ans[index] = i + min; // 将数字从桶数组映射回原数组的值
                    index++;              // 更新结果数组的索引
                }
            }
            maxF--; // 减少最大频率，继续查找下一个频率最高的数字
        }

        return ans; // 返回结果数组
    }



}
