package com.programmer.carl.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 21:15
 * @description:
 */
public class T904FruitBaskets {

    /**
     * 寻找最多包含 2 个元素的子数组的最大长度
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        HashMap<Integer, Integer> notes = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < fruits.length) {
            notes.put(fruits[r], notes.getOrDefault(fruits[r], 0) + 1);
            r++;
            if (notes.size() <= 2) {
                maxLen = Math.max(maxLen, r - l);
            } else {
                while (notes.size() > 2) {
                    // 将左边的水果扔掉
                    if (notes.get(fruits[l]) == 1) {
                        notes.remove(fruits[l]);
                    } else {
                        notes.put(fruits[l], notes.get(fruits[l]) - 1);
                    }
                    l++;
                }
            }
        }
        return maxLen;
    }

    @Test
    public void testSolution() {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}
