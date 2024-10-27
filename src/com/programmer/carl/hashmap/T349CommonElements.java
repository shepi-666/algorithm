package com.programmer.carl.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 10:10
 * @description:
 */
public class T349CommonElements {

    /**
     * 两个数组中的相同元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] isExist = new boolean[10001];
        Set<Integer> temp = new HashSet<>();
        for (int num : nums1) {
            isExist[num] = true;
        }
        for (int num : nums2) {
            if (isExist[num]) {
                temp.add(num);
            }
        }
        int[] commons = new int[temp.size()];
        int i = 0;
        for (int num : temp) {
            commons[i++] = num;
        }
        return commons;

    }
}
